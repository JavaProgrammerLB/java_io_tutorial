package liubei.java.nio.tutorial.nio_example_selector.while_true;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class WhileTrueSelectorServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));
            serverSocketChannel.configureBlocking(false);

            // Selector
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun){
                int keyCount = selector.select();
                Set<SelectionKey> selectionKeySet = selector.keys();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                System.out.println("keyCount = " + keyCount);
                System.out.println("selectionKeySet = " + selectionKeySet);
                System.out.println("selectedKeys = " + selectedKeys);
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
