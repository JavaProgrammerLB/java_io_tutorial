package liubei.java.nio.tutorial.file_channel_lock;

import liubei.java.nio.tutorial.file_channel_tutorial.FilePathUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelFileLockAsynchronousCloseExceptionTutorial {

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

        // 线程1调用fileChannel的lock方法
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    fileChannel.lock(1, 2, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // 线程2调用fileChannel的close方法
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // 启动线程
        thread.start();
        Thread.sleep(2);
        thread1.start();

        // close
        Thread.sleep(1000);
        fileChannel.close();
        fileOutputStream.close();
    }

}
