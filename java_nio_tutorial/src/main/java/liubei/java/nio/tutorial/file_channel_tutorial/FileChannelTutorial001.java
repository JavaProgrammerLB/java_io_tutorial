package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTutorial001 {

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/liubei/Program/gitworkspace/codes/java_io_tutorial/java_nio_tutorial/src/main/resources/a.txt"));
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap("abcde".getBytes());
            System.out.println("position: " + fileChannel.position());
            System.out.println("write1 返回值： " + fileChannel.write(byteBuffer));
            System.out.println("postion2: " + fileChannel.position());
            fileChannel.position(2);
            byteBuffer.rewind();
            System.out.println("write2 返回值：" + fileChannel.write(byteBuffer));
            System.out.println("postion3: " + fileChannel.position());
            fileChannel.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
