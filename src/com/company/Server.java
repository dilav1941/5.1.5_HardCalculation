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
            System.out.println("New connection accepted");
            //получаем число
            String num;
            while ((num = in.readLine()) != null) {
                //Получаем N-ное число
                int fibonacciN = fibonacci(Integer.parseInt(num));
                System.out.println("Send number to client: " + fibonacciN);
                //Отправляем его клиенту
                out.println(fibonacciN);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Вычисление N-ного числа Фибоначчи до 46 значения
    private static int fibonacci(int num) {
        if (num <= 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}