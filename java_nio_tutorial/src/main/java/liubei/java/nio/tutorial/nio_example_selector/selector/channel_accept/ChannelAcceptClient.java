package liubei.java.nio.tutorial.nio_example_selector.selector.channel_accept;

import java.io.IOException;
import java.net.Socket;

public class ChannelAcceptClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
