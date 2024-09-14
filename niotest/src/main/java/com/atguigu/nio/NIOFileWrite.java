package com.atguigu.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileWrite {
    public static void main(String[] args) {
        String content = "Hello, NIO!";
        try (FileChannel fileChannel = FileChannel.open(Paths.get("output.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            ByteBuffer buffer = StandardCharsets.UTF_8.encode(content);
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
