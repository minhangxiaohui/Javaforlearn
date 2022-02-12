package fordecodegesila;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Mydecodeforshrio {
    public static void main(String[] args) throws  Exception{

//        String basedate = "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";
        String  key = "4AvVhmFLUs0KTA3Kprsdag==";
//        String enkey =new String(Base64.getEncoder().encode(key.getBytes("utf-8")));
//        System.out.println("base编码之后:"+enkey);
        String a =new String( Base64.getDecoder().decode(key.getBytes("utf-8")));
        System.out.println("解码之后："+a);
        //
//        byte [] mykey = Base64.getDecoder().decode(key).toString().getBytes("utf-8");
//
//        byte[] mydata = Base64.getDecoder().decode(basedate);
//        System.out.println("base64解码后的："+new String(mydata));
//
////        String iv =new String(mydata).substring(0,16);
//
//
//
//
//        String iv ="0123456789abcdef";
//
//
//
//
//        System.out.println("iv:"+iv);
//        byte [] data = (new String(mydata)).substring(16).getBytes();



//        String data= "hello world";
//        String key="";
//        String iv ="";
//
//
//        Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5Padding");

//        Key speckey = new SecretKeySpec(key,"AES");
//        IvParameterSpec ivParameterSpec= new IvParameterSpec(iv.getBytes("utf-8"));
//        cipher.init(Cipher.DECRYPT_MODE,speckey,ivParameterSpec);
//        byte [] result = cipher.doFinal(data);
//        System.out.println("使用密钥："+Base64.getEncoder().encode(mykey).toString()+"解密成功:"+result);

    }
}
