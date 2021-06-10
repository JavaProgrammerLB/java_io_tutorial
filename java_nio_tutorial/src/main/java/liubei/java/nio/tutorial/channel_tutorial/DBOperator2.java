package liubei.java.nio.tutorial.channel_tutorial;

import java.io.Closeable;
import java.io.IOException;

public class DBOperator2 implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("close");
    }
}
