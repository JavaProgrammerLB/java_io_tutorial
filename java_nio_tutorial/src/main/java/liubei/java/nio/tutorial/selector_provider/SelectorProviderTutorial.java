package liubei.java.nio.tutorial.selector_provider;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;

public class SelectorProviderTutorial {

    public static void main(String[] args) {
        try {
            SelectorProvider provider = SelectorProvider.provider();
            System.out.println("provider info: " + provider.getClass().getName());
            Selector selector = provider.openSelector();
            System.out.println("openSelector() = " + selector.getClass().getName());

            DatagramChannel datagramChannel = provider.openDatagramChannel();
            System.out.println("openDatagramChannel() = " + datagramChannel.getClass().getName());

            DatagramChannel datagramChannel1 = provider.openDatagramChannel(StandardProtocolFamily.INET);
            System.out.println("openDatagramChannel() inet = " + datagramChannel1.getClass().getName());

            DatagramChannel datagramChannel2 = provider.openDatagramChannel(StandardProtocolFamily.INET6);
            System.out.println("openDatagramChannel() inet6 = " + datagramChannel2.getClass().getName());

            Pipe pipe = provider.openPipe();
            System.out.println("openPipe(): " + pipe.getClass().getName());

            ServerSocketChannel serverSocketChannel = provider.openServerSocketChannel();
            System.out.println("openServerSocketChannel(): " + serverSocketChannel.getClass().getName());

            SocketChannel socketChannel = provider.openSocketChannel();
            System.out.println("openSocketChannel(): " + socketChannel.getClass().getName());

            Channel channel = provider.inheritedChannel();
            System.out.println("inheritedChannel(): " + channel.getClass().getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
