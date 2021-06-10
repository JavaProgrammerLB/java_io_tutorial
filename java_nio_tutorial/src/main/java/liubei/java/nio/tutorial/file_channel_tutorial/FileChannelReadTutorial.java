package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadTutorial {

    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File file = new File(FilePathUtil.getFilePath() + "a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        // 获取通道
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        // 通过通道结合ByteBuffer读取文件
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
        int l = fileChannel.read(byteBuffer);
        System.out.println("l = " + l);

        int l2 = fileChannel.read(byteBuffer);
        System.out.println("l2 = " + l2);

        byteBuffer.clear();
        int l3 = fileChannel.read(byteBuffer);
        System.out.println("l3 = " + l3);
        // 通道和文件输入流的关闭
        fileChannel.close();
        fileInputStream.close();
    }

}
