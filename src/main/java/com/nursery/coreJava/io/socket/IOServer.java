package com.nursery.coreJava.io.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio每链接占用一线程
 */
public class IOServer {
    public static void main(String[] args) throws Exception {
        //ServerSocket在该套接字上监听连接事件
        ServerSocket serverSocket = new ServerSocket(8089, 1,
                InetAddress.getByName("127.0.0.1")); // socket()=3;bind(3,9090)
        //服务端阻塞在accept()方法上，直到客户端的connect()请求，并返回一个Socket对象
        Socket socket = serverSocket.accept(); // 系统调用accept(3,
        //从返回的Socket对象中获取该Socket对应的套接字文件的内容并进行读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        socket.close();
    }
}
