package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockOverlapTutorial {

    public static void main(String[] args) throws IOException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 通过RandomAccessFile对象获取Channel
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        // 实验操作
        FileLock fileLock  = fileChannel.lock(1, 10, true);
        System.out.println("overlap: " + fileLock.overlaps(5, 10));

        // close
        fileLock.close();
        fileChannel.close();
        randomAccessFile.close();
    }

}
