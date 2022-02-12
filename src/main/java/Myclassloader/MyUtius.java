package Myclassloader;


import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import mybcel.Eval;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
//jdk8及以上的base64使用
import java.util.Base64;
////jdk7中的base64使用
//import sun.misc.BASE64Encoder;

public class MyUtius {
    public static void main(String[] args) throws   Exception{
//        找到恶意类的class文件 恶意类：Evalforbytes
        JavaClass cls = Repository.lookupClass(Evalforbytes.class);
//        URI url = MyUtius.class.getClassLoader().getResource("Evalforbytes.class").toURI();
//        byte [] bytes = Files.readAllBytes(Paths.get(url));

//        将恶意类的class字节码文件base64编码输出
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        String base = base64Encoder.encode(cls.getBytes());
//        jdk8及以上
      String base = Base64.getEncoder().encodeToString(cls.getBytes());
        System.out.println(base);


    }
}
