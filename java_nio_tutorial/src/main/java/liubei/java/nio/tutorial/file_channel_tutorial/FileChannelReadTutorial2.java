package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadTutorial2 {

    private static FileInputStream fileInputStream;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        File file = new File(FilePathUtil.getFilePath() + "a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        fileInputStream = new FileInputStream(file);
        fileChannel = fileInputStream.getChannel();

        // 实验操作
        fileChannel.position(2);

        // 创建ByteBuffer并进行读取
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        fileChannel.read(byteBuffer);

        // 打印byteBuffer里读取到的内容
        byte[] bytes = byteBuffer.array();
        if (bytes != null) {
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                System.out.println(": " + (char) b);
            }
        }
        fileChannel.close();
        fileInputStream.close();
    }

}
