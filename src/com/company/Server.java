package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(25757);


        try (Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Новое соежинение");
            //получаем число
            String num;
            while ((num = in.readLine()) != null) {
                //Получаем N-ное число
                int fibonachiN = fibonachi(Integer.parseInt(num));
                System.out.println("Отправляем номер пользователю: " + fibonachiN);
                //Отправляем его клиенту
                out.println(fibonachiN);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Вычисление N-ного числа Фибоначчи до 46 значения
    private static int fibonachi(int num) {
        if (num <= 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibonachi(num - 1) + fibonachi(num - 2);
        }
    }
}