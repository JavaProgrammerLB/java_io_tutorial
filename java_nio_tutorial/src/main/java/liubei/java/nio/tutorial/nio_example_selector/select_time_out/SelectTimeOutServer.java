package liubei.java.nio.tutorial.nio_example_selector.select_time_out;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class SelectTimeOutServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
            serverSocketChannel.configureBlocking(false);

            // Selector
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // 调用select方法
            boolean isRun = true;
            while (isRun) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
                System.out.println("while (isRun == true)" + simpleDateFormat.format(new Date()));
                selector.select(5000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();

                Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                while (selectionKeyIterator.hasNext()){
                    System.out.println("进入while");
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)selectionKey.channel();
                        ServerSocket serverSocket = serverSocketChannel1.socket();
                        Socket socket = serverSocket.accept();
                        socket.close();
                    }
                    selectionKeyIterator.remove();
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
