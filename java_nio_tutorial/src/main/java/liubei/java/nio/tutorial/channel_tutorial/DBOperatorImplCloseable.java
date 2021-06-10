package liubei.java.nio.tutorial.channel_tutorial;

import java.io.Closeable;
import java.io.IOException;

public class DBOperatorImplCloseable implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("close run");
    }

}
