package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTutorial002 {

    public static void main(String[] args) {
        try {
            String filePath = FilePathUtil.getFilePath() + "b.txt";
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 获取通道
            FileChannel fileChannel = fileOutputStream.getChannel();

            // 创建ByteBuffer
            ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde".getBytes());
            ByteBuffer byteBuffer2 = ByteBuffer.wrap("12345".getBytes());

            // 通过channel传输ByteBuffer
            fileChannel.write(byteBuffer1);

            fileChannel.write(byteBuffer2);

            // close操作
            fileChannel.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
