package com.atguigu.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AIOServer {

    private static final int PORT = 8086;

    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new java.net.InetSocketAddress(PORT));

        CountDownLatch latch = new CountDownLatch(1);
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println("New client connected: " + result);
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                result.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer num, ByteBuffer attachment) {
                        if (num > 0) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            System.out.println("Message received: " + new String(bytes));
                            attachment.clear();
                            // 重新读取
                            result.read(attachment, attachment, this);
                        } else {
                            System.out.println("Client disconnected: " + result);
                            try {
                                result.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                        try {
                            result.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                latch.countDown();
            }
        });

        latch.await();
    }
}
