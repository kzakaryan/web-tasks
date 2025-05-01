package com.bobocode.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.bobocode.net.server.ServerUtil.*;

/**
 * MessageBoardServer is a server application that allows clients to connect via socket
 * and prints messages from each client. It uses a new thread for each client to support multiple clients.
 */
public class MessageBoardServer {
    public static final String HOST = ServerUtil.getLocalHost();
    public static final int PORT = 8899; // you can use any free port you want

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = createServerSocket(PORT)) {
            System.out.println("Server is running...");
            while (true) {
                try {
                    Socket clientSocket = acceptClientSocket(serverSocket);
                    new Thread(new ClientHandler(clientSocket)).start(); // Handle each client in a new thread
                } catch (Exception e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        }
    }

    /**
     * ClientHandler handles the message reading and printing for a single client.
     */
    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                String message = readMessageFromSocket(clientSocket);
                printMessage(clientSocket, message);
            } catch (Exception e) {
                System.err.println("Error reading from client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close(); // Close the socket after handling the client
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}
