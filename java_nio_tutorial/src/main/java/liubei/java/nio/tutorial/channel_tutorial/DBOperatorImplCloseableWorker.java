package liubei.java.nio.tutorial.channel_tutorial;

import java.io.IOException;

public class DBOperatorImplCloseableWorker {

    public static void main(String[] args) {
        try (DBOperatorImplCloseable dbOperatorImplCloseable = new DBOperatorImplCloseable()){
            System.out.println("Go Go Go!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
