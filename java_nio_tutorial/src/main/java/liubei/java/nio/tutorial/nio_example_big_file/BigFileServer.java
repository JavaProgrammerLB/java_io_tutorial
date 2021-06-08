package liubei.java.nio.tutorial.nio_example_big_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class BigFileServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));

            // Selector
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun) {
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    selectionKeyIterator.remove();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_WRITE);
                    }
                    if (selectionKey.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        FileInputStream fileInputStream = new FileInputStream("/Users/liubei/tmp/abbb.txt");
                        FileChannel fileChannel = fileInputStream.getChannel();
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
                        while (fileChannel.position() < fileChannel.size()){
                            fileChannel.read(byteBuffer);
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()){
                                socketChannel.write(byteBuffer);
                            }
                            byteBuffer.clear();
                            System.out.println("fileChannel position is :" + fileChannel.position() + "fileChannel size is :" + fileChannel.size());
                        }
                        System.out.println("结束写操作");
                        socketChannel.close();
                    }
                    serverSocketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
