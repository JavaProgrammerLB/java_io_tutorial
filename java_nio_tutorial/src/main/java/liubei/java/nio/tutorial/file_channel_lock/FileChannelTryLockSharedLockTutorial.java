package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileChannelTryLockSharedLockTutorial {

    private static RandomAccessFile randomAccessFile;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 从FileOutputStream获取FileChannel
        randomAccessFile = new RandomAccessFile(file, "rw");
        fileChannel = randomAccessFile.getChannel();

        // 调用tryLock方法
        FileLock fileLock = fileChannel.tryLock(1, 2, true);
        System.out.println("B fileLock = " + fileLock);

        // close
        Thread.sleep(1000);
        fileChannel.close();
        randomAccessFile.close();
    }

}
