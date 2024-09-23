package com.atguigu.designmethods.atomClone.SerializableClone;

import java.io.*;

public class DeepCopyUtil {

    public static <T> T deepCopy(T object) {
        try {
            // 将对象写入字节流
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(object);

            // 从字节流中读取对象
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}