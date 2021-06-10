package liubei.java.nio.tutorial.file_channel_tutorial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MultiThreadFileChannelTutorial {

    private static FileOutputStream fileOutputStream;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建文件
        File file = new File(FilePathUtil.getFilePath() + "c.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        // 获取Channel
        fileOutputStream = new FileOutputStream(file);
        fileChannel = fileOutputStream.getChannel();

        // 创建十个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("abcde\r\n".getBytes());
                    try {
                        fileChannel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("我是中国人\r\n".getBytes());
                    try {
                        fileChannel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();
            thread1.start();
        }
        Thread.sleep(3000);
        fileChannel.close();
        fileOutputStream.close();
    }

}
