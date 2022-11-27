package ru.croc.task11;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Right your name");
        System.out.print(">");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        // запускаем подключение сокета по известным координатам и нициализируем приём сообщений с консоли клиента
        try (Socket socket = new Socket("localhost", 8081);
             BufferedReader message = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader inputMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Right your message to other user\n");

            while (true) {
                // считываем данные с консоли
                if (message.ready()) {

                    String clientCommand = message.readLine();

                    // клиент отключился от сервера
                    if (clientCommand.equalsIgnoreCase("QUIT")) {

                        response.write(String.valueOf(socket.getLocalPort()));
                        response.newLine();
                        response.flush();

                        socket.close();
                        break;
                    }

                    // пишем данные с консоли в канал сокета для сервера
                    response.write(String.format("%s: %s", name, clientCommand));
                    response.newLine();
                    response.flush();
                }

                // проверяем что написали другие пользователи
                if (inputMessage.ready()) {
                    String in = inputMessage.readLine();
                    System.out.println(in);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
