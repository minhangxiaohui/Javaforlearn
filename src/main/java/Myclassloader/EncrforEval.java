//package Myclassloader;
//
//import com.sun.org.apache.bcel.internal.Repository;
//import com.sun.org.apache.bcel.internal.classfile.JavaClass;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.util.Base64;
//
//public class EncrforEval {
//    public static void main(String[] args) {
//        //读取恶意类字节码
//        JavaClass cls = Repository.lookupClass(Evalforbytes.class);
//        byte[] ss = cls.getBytes();
//
//        //对恶意类字节码加密 ：简单加密+1
//        for (int i =0;i<ss.length;i++)
//        {
//            ss[i]=(byte)(ss[i]-1);
//        }
//        String ssfor64 = Base64.getEncoder().encodeToString(ss);
//        System.out.println(ssfor64);
//    }
//}
