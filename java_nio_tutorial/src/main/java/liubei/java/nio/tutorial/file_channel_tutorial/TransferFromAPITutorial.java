package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferFromAPITutorial {

    public static void main(String[] args) throws IOException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        String filePath2 = FilePathUtil.getFilePath() + "b.txt";
        File file2 = new File(filePath2);
        if (!file2.exists()) {
            file2.createNewFile();
        }

        // 创建RandomAccessFile对象
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(file2, "rw");

        // 获取FileChannel
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileChannel fileChannel1 = randomAccessFile1.getChannel();

        // 进行实验操作
        fileChannel1.position(5);
        long l = fileChannel.transferFrom(fileChannel1, 4, 2);
        System.out.println("l: " + l);

        // 执行close操作
        fileChannel.close();
        fileChannel1.close();

        randomAccessFile.close();
        randomAccessFile1.close();
    }

}
