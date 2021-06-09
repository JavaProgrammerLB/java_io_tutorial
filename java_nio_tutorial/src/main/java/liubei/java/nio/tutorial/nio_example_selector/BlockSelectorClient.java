package liubei.java.nio.tutorial.nio_example_selector;

import java.io.IOException;
import java.net.Socket;

public class BlockSelectorClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
