package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileChannelTryLockTutorial {

    private static FileOutputStream fileOutputStream;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 从FileOutputStream获取FileChannel
        fileOutputStream = new FileOutputStream(file);
        fileChannel = fileOutputStream.getChannel();

        // 调用tryLock方法
        FileLock fileLock = fileChannel.tryLock(1, 2, false);
        System.out.println("A fileLock = " + fileLock);

        // close
        Thread.sleep(Integer.MAX_VALUE);
        fileChannel.close();
        fileOutputStream.close();
    }

}
