package com.bobocode.net.client;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

/**
 * A utility class that implements all the logic required for building MessageBoardClient.
 */
public class ClientUtil {
    private ClientUtil() {
    }

    /**
     * Using provided host and port, it creates an instance of a new Socket using two-argument constructor.
     * This means that the returned socket will be already connected to the server, or will throw an error if the connection fails.
     *
     * @param host server host
     * @param port server port
     * @return an instance of a connected socket
     */
    @SneakyThrows
    public static Socket openSocket(String host, int port) {
        return new Socket(host, port); // Creates and connects the socket
    }

    /**
     * Creates a simple BufferedReader that allows reading messages from the console.
     *
     * @return console-based BufferedReader
     */
    @SneakyThrows
    public static BufferedReader openConsoleReader() {
        InputStreamReader consoleInputStream = new InputStreamReader(System.in);
        return new BufferedReader(consoleInputStream);
    }

    /**
     * Prints a prompt and reads a line using provided reader.
     *
     * @param reader
     * @return the message read by the reader
     */
    @SneakyThrows
    public static String readMessage(BufferedReader reader) {
        System.out.print("Enter message (q to quit): ");
        return reader.readLine();
    }

    /**
     * This is the most important method of this class. It allows writing a string message to the given socket.
     * In order to write to the connected socket, it uses its OutputStream. But since we need to write text
     * messages, it creates a BufferedWriter based on the OutputStream. A writer allows writing String messages instead of bytes.
     * It forces sending data to the remote socket by flushing the writer's buffer.
     *
     * @param message a message to send to the socket
     * @param socket a socket instance connected to the server
     */
    @SneakyThrows
    public static void writeToSocket(String message, Socket socket) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write(message); // Write the message to the socket
            writer.newLine(); // Add a newline to indicate the end of the message
            writer.flush(); // Flush the buffer to ensure the message is sent
        }
    }
}
