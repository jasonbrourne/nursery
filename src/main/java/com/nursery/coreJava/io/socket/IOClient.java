package com.nursery.coreJava.io.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class IOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        //通过一个IP:PORT套接字新建一个Socket对象，确定要连接的服务器的位置和端口
        Socket socket = new Socket("127.0.0.1", 8653);
        //通过Socket对象拿到OutputStream，可以将其理解通过其向服务器端对应的套接字文件写入数据
        OutputStream outputStream = socket.getOutputStream();
        //使用默认的字符集去解析outputStream的字节流
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        /*向服务器发送一个HTTP1.1的请求*/
        printWriter.println("GET /index.html HTTP/1.1");
        printWriter.println("Host: localhost:8080");
        printWriter.println("Connection Close");
        printWriter.println();
        Thread.sleep(10000000L);
        socket.close();
    }
}
