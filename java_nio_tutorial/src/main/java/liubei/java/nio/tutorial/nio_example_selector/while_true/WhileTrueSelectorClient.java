package liubei.java.nio.tutorial.nio_example_selector.while_true;

import java.io.IOException;
import java.net.Socket;

public class WhileTrueSelectorClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
