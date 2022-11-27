package ru.croc.task11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final ExecutorService execute = Executors.newFixedThreadPool(3);
    private static final List<Socket> sockets = new ArrayList<>();
    // можно подключиться с консоли windows, через терминал idea, запустить в idea

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8081)) {

            while (true) {
                try {
                    Socket newSocket = serverSocket.accept();

                    sockets.add(newSocket);

                    execute.execute(new Controller(newSocket));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

//            execute.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Socket> getSockets() {
        return sockets;
    }
}