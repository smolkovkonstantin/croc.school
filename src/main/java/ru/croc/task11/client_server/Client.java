package ru.croc.task11.client_server;

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
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream())) {

            System.out.printf("Client %s connect\n", name);
            System.out.println("Right your message to other user");

            while (!socket.isOutputShutdown()) {

                // считываем данные с консоли
                if (br.ready()) {

                    String clientCommand = br.readLine();

                    // пишем данные с консоли в канал сокета для сервера
                    oos.writeUTF(String.format("%s: %s",name, clientCommand));
                    oos.flush();

                    // клиент отключился от сервера
                    if (clientCommand.equals("QUIT")) {
                        break;
                    }

                    // проверяем что написали другие пользователи
                    if (ois.read() > -1) {
                        String in = ois.readUTF();
                        System.out.println(in);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
