package liubei.java.nio.tutorial.channel_tutorial;

public class DBOperator implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("关闭连接");
    }

}
