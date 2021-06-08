package liubei.java.nio.tutorial.nio_example_big_file;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class BigFileClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            // Selector
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            boolean isRun = true;
            while (isRun) {
                System.out.println("begin selector");
                if (socketChannel.isOpen()) {
                    selector.select();
                    System.out.println(" end selector");

                    // SelectorKeys
                    Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                    Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        selectionKeyIterator.remove();
                        if (selectionKey.isConnectable()) {
                            while (!socketChannel.finishConnect()) {
                            }
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (selectionKey.isReadable()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(9);
                            int readLength = socketChannel.read(byteBuffer);
                            byteBuffer.flip();
                            long count = 0;
                            while (readLength != -1) {
                                count = count + readLength;
                                System.out.println("count = " + count + " readLength: " + readLength);
                                readLength = socketChannel.read(byteBuffer);
                                byteBuffer.clear();
                            }
                            System.out.println("读取结束");
                            socketChannel.close();
                        }
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
