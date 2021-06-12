package liubei.java.nio.tutorial.buffer_tutorial;

import java.nio.ByteBuffer;

public class ByteBufferTutorial {

    public static void main(String[] args) {
        // 通过wrap方法创建ByteBuffer对象
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println("[wrap] capacity = " + byteBuffer.capacity() + " position = " + byteBuffer.position()
        + " limit = " + byteBuffer.limit());

        // 进行试验操作
        byteBuffer.position(1);
        byteBuffer.limit(3);
        byteBuffer.mark();
        System.out.println("[position-limit-mark] capacity = " + byteBuffer.capacity() + " position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit());

        // rewind
        byteBuffer.rewind();
        System.out.println("[rewind] capacity = " + byteBuffer.capacity() + " position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit());

        byteBuffer.clear();
        System.out.println("[clean] capacity = " + byteBuffer.capacity() + " position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit());

    }

}
