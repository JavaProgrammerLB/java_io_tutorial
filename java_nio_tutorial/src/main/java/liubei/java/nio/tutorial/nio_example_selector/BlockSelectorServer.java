package liubei.java.nio.tutorial.nio_example_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class BlockSelectorServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            System.out.println("1");
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));
            System.out.println(2);
            serverSocketChannel.configureBlocking(false);
            System.out.println(3);

            // Selector
            Selector selector = Selector.open();
            System.out.println(4);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println(5);
            int selectionKey = selector.select();
            System.out.println(6);
            System.out.println("selectionKey = " + selectionKey);
            serverSocketChannel.close();
            System.out.println(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
