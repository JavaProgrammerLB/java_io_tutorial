package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelLockTutorial {

    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = FilePathUtil.getFilePath() + "a.txt";
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }

        // 通过RandomAccessFile对象获取Channel
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        // 实验操作
        System.out.println("A begin");
        fileChannel.lock(1, 2, false);
        System.out.println("A end");
        Thread.sleep(Integer.MAX_VALUE);

        // close
        fileChannel.close();
        randomAccessFile.close();
    }

}
