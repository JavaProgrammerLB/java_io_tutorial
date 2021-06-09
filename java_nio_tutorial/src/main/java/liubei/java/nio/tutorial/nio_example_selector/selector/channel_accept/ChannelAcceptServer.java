package liubei.java.nio.tutorial.nio_example_selector.selector.channel_accept;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChannelAcceptServer {

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
                int selectKeyCount = selector.select();
                Set<SelectionKey> selectionKeySet = selector.keys();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                System.out.println("selectKeyCount = " + selectKeyCount + " selectionKeySet siz = " + selectionKeySet.size() + " selectedKeys = " + selectedKeys.size());
                Iterator<SelectionKey> selectedKeyIterator = selectedKeys.iterator();
                while (selectedKeyIterator.hasNext()){
                    SelectionKey selectionKey = selectedKeyIterator.next();
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)selectionKey.channel();
                    serverSocketChannel1.accept();
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
