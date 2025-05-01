package com.bobocode.net.server;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for the MessageBoardServer.
 * Provides methods for creating server socket, accepting clients, reading messages from client, and printing them.
 */
public class ServerUtil {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private ServerUtil() {
    }

    /**
     * A simple method that returns localhost
     *
     * @return localhost address
     */
    @SneakyThrows
    public static String getLocalHost() {
        return InetAddress.getLocalHost().getHostAddress();
    }

    /**
     * Creates an instance of a ServerSocket based on the given port.
     *
     * @param port the port number
     * @return a new bound ServerSocket instance
     */
    @SneakyThrows
    public static ServerSocket createServerSocket(int port) {
        return new ServerSocket(port); // Creates and binds the server socket to the specified port
    }

    /**
     * This method accepts a client on a given serverSocket and returns an accepted socket instance.
     *
     * @param serverSocket an open server socket
     * @return an instance of an accepted client socket
     */
    @SneakyThrows
    public static Socket acceptClientSocket(ServerSocket serverSocket) {
        return serverSocket.accept(); // Accepts a client connection and returns the socket
    }

    /**
     * Reads a message sent by the client from the socket's InputStream.
     *
     * @param socket the accepted socket
     * @return message received from the client
     */
    @SneakyThrows
    public static String readMessageFromSocket(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            return reader.readLine(); // Reads a line from the socket's input stream
        }
    }

    /**
     * Prints the message with timestamp and client IP address.
     *
     * @param socket the accepted socket
     * @param message the message to print
     */
    public static void printMessage(Socket socket, String message) {
        InetAddress clientAddress = socket.getInetAddress();
        System.out.print(LocalDateTime.now().format(TIME_FORMATTER) + " ");
        System.out.printf("[%s]", clientAddress.getHostAddress());
        System.out.println(" -- " + message);
    }
}
