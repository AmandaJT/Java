package code_04_network.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 18351 on 2019/1/5.
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //1. 创建接收端的Socket对象
        ServerSocket serverSocket=new ServerSocket(8888);

        //2. 监听客户端连接。返回一个对应的Socket对象
        Socket socket=serverSocket.accept();

        //3. 获取输入流，读取数据显示在控制台
        InputStream inputStream=socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        String str = new String(bys, 0, len);
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "---" + str);

        //向客户端发送数据
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("数据已经收到".getBytes());

        //4. 释放资源
        socket.close();
    }
}