import cn.hutool.crypto.digest.MD5;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class Test {


    public static void main(String[] args) {
        String key="e4ccfbbab7fc4fbbaacd99dde465e96b";
        String secretKey = "E42C73E832191E8D9DA7D69B5834D944";

        long epochSecond = Instant.now().getEpochSecond();
        String input = key+epochSecond+secretKey; // 输入的字符串

        try {
            // 创建MD5加密算法实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将输入字符串转换为字节数组，并进行MD5加密
            byte[] hashedBytes = md.digest(input.getBytes());

            // 将加密后的字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            String md5Hash = sb.toString();
            System.out.println("时间错: " + epochSecond);
            System.out.println("MD5 Hash小写: " + md5Hash);
            System.out.println("MD5 Hash大写: " + md5Hash.toUpperCase());
            System.out.println("MD5 Hash: " + md5Hash.length());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
