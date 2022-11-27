package ru.croc.task11;

import java.io.*;
import java.net.Socket;

public class Controller implements Runnable {

    private final Socket thisClient;

    public Controller(Socket thisClient) {
        this.thisClient = thisClient;
    }

    @Override
    public void run() {

        try (BufferedReader request = new BufferedReader(new InputStreamReader(thisClient.getInputStream()))) {
            while (!thisClient.isClosed()) {
                synchronized (Server.getSockets()) {
                    if (request.ready()) {

                        String message = request.readLine();

                        // если пользователь вышел, то отключаем его

                        // рассылаем всем пользователям сообщение
                        if (closeSocket(message)) {
                            sendMessage(message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage(String message) {
        Server.getSockets().forEach(socket -> {
            if (!thisClient.equals(socket) && !socket.isClosed()) {
                try {
                    BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    response.write(message);
                    response.newLine();
                    response.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private boolean closeSocket(String message) {
        for (Socket socket : Server.getSockets()) {
            if (message.equals(String.valueOf(socket.getPort()))) {
                try {
                    socket.close();
                    return false;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }
}

