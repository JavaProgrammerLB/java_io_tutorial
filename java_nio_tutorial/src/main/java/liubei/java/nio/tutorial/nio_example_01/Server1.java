package liubei.java.nio.tutorial.nio_example_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Server1 {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress("localhost", 8888));
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1024];
            int readableLength = inputStreamReader.read(charArray);
            while (readableLength != -1) {
                String str = new String(charArray, 0, readableLength);
                System.out.println(str);
                readableLength = inputStreamReader.read(charArray);
            }
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
