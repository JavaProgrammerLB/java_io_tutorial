package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockApiTutorial {

    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 通过RandomAccessFile对象获取Channel
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        // 调用FileLock的API
        System.out.println("fileChannel的hashCode为：" + fileChannel.hashCode());
        FileLock fileLock = fileChannel.lock(1, 2, true);

        // 获取相应方法的值
        System.out.println("[FIR] fileLock position = " + fileLock.position() + " fileLock size = " + fileLock.size()
                + " fileLock isValid = " + fileLock.isValid() + " isShared = " + fileLock.isShared() +
                " fileLock.channel().hashCode = " + fileLock.channel().hashCode()
                + " fileLock.acquireBy().hashCode = " + fileLock.acquiredBy().hashCode()
        );

        // 实验操作
        fileLock.release();

        // 第二次lock
        fileLock = fileChannel.lock(1, 10, false);
        // 获取相应方法的值
        System.out.println("[SEC] fileLock position = " + fileLock.position() + " fileLock size = " + fileLock.size()
                + " fileLock isValid = " + fileLock.isValid() + " isShared = " + fileLock.isShared() +
                " fileLock.channel().hashCode = " + fileLock.channel().hashCode()
                + " fileLock.acquireBy().hashCode = " + fileLock.acquiredBy().hashCode()
        );

        // 实验操作
        fileLock.close();
        fileChannel.close();
        System.out.println("[THI] fileLock position = " + fileLock.position() + " fileLock size = " + fileLock.size()
                + " fileLock isValid = " + fileLock.isValid() + " isShared = " + fileLock.isShared() +
                " fileLock.channel().hashCode = " + fileLock.channel().hashCode()
                + " fileLock.acquireBy().hashCode = " + fileLock.acquiredBy().hashCode()
        );

        // close
        randomAccessFile.close();
    }

}
