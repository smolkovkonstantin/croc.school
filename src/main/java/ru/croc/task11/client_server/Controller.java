package ru.croc.task11.client_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Controller implements Runnable {

    private final Socket client;
    private final List<Socket> sockets;

    public Controller(Socket client, List<Socket> sockets) {
        this.client = client;
        this.sockets = sockets;
    }

    @Override
    public void run() {

        try {
            List<DataOutputStream> outs = new ArrayList<>();

            for (Socket anotherClient : sockets){
                outs.add(new DataOutputStream(anotherClient.getOutputStream()));
            }

            DataInputStream in = new DataInputStream(client.getInputStream());

            // начинаем диалог с подключенным клиентом в цикле, пока сокет не
            // закрыт клиентом
            while (!client.isClosed()) {

                // данные от пользователя
                String clientMessage = in.readUTF();

                System.out.println("Message: " + clientMessage);

                // Завершение сессии, если пользователь вышел
                if (clientMessage.equals("QUIT")) {
                    break;
                }

                // отправляем сообщения другим клиентам
                for (DataOutputStream out: outs){
                    out.writeUTF("Message from " + clientMessage);
                    out.flush();
                }

            }

            in.close();
            for (DataOutputStream out : outs) {
                out.close();
            }

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
