package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOTestClient {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.connect(new InetSocketAddress(HOST, PORT));
        if (socketChannel.finishConnect()) {
            socketChannel.register(selector, SelectionKey.OP_WRITE);
        }

        while (true) {
            System.out.println("NIOTestClient开始循环");
            if (selector.select() == 0) {
                System.out.println("continue中");
                continue;
            }
            System.out.println("continue过了");
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                if (key.isWritable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.wrap("Hello, NIO Server!".getBytes());
                    channel.write(buffer);
                    channel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = channel.read(buffer);
                    if (read > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        System.out.println("Message received from server: " + new String(bytes));
                    }
                }
                ite.remove();
            }
        }
    }
}
