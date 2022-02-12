//package fordecodegesila;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.*;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
///**
// * AES加密128位CBC模式工具类
// */
//public class AESUtils {
//
//    //解密密钥(自行随机生成)
//    public static final String KEY = "4AvVhmFLUs0KTA3Kprsdag==";//密钥key
//    public static final String IV  = "";//向量iv
//
//    //加密
//    public static String Encrypt(String content) throws Exception {
//        byte[] raw = KEY.getBytes("utf-8");
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
//        //使用CBC模式，需要一个向量iv，可增加加密算法的强度
//        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ips);
//        byte[] encrypted = cipher.doFinal(content.getBytes());
//        return new BASE64Encoder().encode(encrypted);
//    }
//
//    //解密
//    public static String Decrypt(String content) throws Exception {
//
//
//            byte[] raw = Base64.getDecoder().decode(KEY.getBytes());
////            byte[] raw = KEY.getBytes("utf-8");
//            System.out.println("123aaa:"+content.length());
//            String s = new String(Base64.getDecoder().decode(content));
//            String iv = s.substring(0,16);
//            byte[] encrypted1 = s.substring(16).getBytes("utf-8");
//            System.out.println("长度："+encrypted1.length);
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ips);
////             = new BASE64Decoder().decodeBuffer(data);
////            System.out.println("1");
////            System.out.println("123"+new String(encrypted1,"utf-8"));
////
////            String s = "kPH+bIxk5D2deZiIxcaaaA==";
////            byte[] encrypted12= Base64.getDecoder().decode(s);
////            System.out.println("base解码后内容"+new String(encrypted12,"utf-8"));
//
//
//            try {
//                byte[] original = cipher.doFinal(encrypted1);
//                String originalString = new String(original);
//                return originalString;
//            } catch (Exception e) {
//
//                System.out.println(e.toString());
//                return null;
//            }
//
//    }
//
//
//
//
//
//
//}