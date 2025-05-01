package com.bobocode.net.client;

import com.bobocode.net.server.MessageBoardServer;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.net.Socket;

import static com.bobocode.net.client.ClientUtil.*;

/**
 * MessageBoardClient is a client application that connects to the MessageBoardServer
 * and sends messages. It will continuously ask for user input and send the message to the server.
 * The client will exit if the user enters 'q'.
 */
public class MessageBoardClient {
    private static final String SERVER_ADDRESS = MessageBoardServer.HOST;
    private static final int SERVER_PORT = MessageBoardServer.PORT;

    @SneakyThrows
    public static void main(String[] args) {
        try (BufferedReader reader = openConsoleReader()) {
            String message = readMessage(reader);

            while (!message.equals("q")) {
                try (Socket socket = openSocket(SERVER_ADDRESS, SERVER_PORT)) {
                    writeToSocket(message, socket);
                } catch (Exception e) {
                    System.err.println("Error connecting to server: " + e.getMessage());
                }
                message = readMessage(reader); // Get new message from user
            }

            System.out.println("Disconnected from the server.");
        }
    }
}
