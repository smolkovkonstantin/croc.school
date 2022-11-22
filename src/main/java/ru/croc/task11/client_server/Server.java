package ru.croc.task11.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final ExecutorService execute = Executors.newFixedThreadPool(3);
    protected static final List<Socket> sockets = new ArrayList<>();
    // можно подключиться с консоли windows, через терминал idea, запустить в idea

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8081);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // стартуем цикл при условии что серверный сокет не закрыт
            while (!serverSocket.isClosed()) {

                if (br.ready()) {
                    // закрытие сервера
                    String serverCommand = br.readLine();
                    if (serverCommand.equals("EXIT")) {
                        serverSocket.close();
                        break;
                    }
                }

                // ожидание команды от клиента
                Socket clientSocket = serverSocket.accept();

                sockets.add(clientSocket);

                // выполнение обращения в отдельном потоке
                execute.execute(new Controller(clientSocket, sockets));
            }
            execute.shutdownNow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}