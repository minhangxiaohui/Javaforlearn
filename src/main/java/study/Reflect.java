package study;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
   反射方式学习
 */
public class Reflect {
    public static void main(String[] args) throws  Exception{

        /*
        获取类
        */
        Class cls = Class.forName("java.lang.Runtime");
        System.out.println(cls);

        Class cls1 = java.lang.Runtime.class;
        System.out.println(cls1);

        Runtime rt = Runtime.getRuntime();
        Class cls2 = rt.getClass();
        System.out.println(cls2);

        Class cls3 = ClassLoader.getSystemClassLoader().loadClass("java.lang.Runtime");
        System.out.println(cls3);

        /*
        获取方法
         */
        Method[] methods1 = cls.getDeclaredMethods();
        for (Method a:methods1){
            System.out.println("declaremethods："+a);
        }
        System.out.println("\n");

        Method[] methods2 = cls.getMethods();
        for (Method s : methods2){
            System.out.println("methods："+s);
        }
        System.out.println("\n");

        Method methods3 = cls.getMethod("exec",String.class);
        System.out.println(methods3
        +"\n");

        Method methods4 = cls.getDeclaredMethod("runFinalization0");
        System.out.println(methods4+"\n");
//
//        getmethod获取私有方法失败
//        Method methods5 = cls.getMethod("runFinalization0");
//        System.out.println(methods5+"\n");
        System.out.println("-------------------------------------------------");

        /*
        获取对象
         */
        Field[] field = Runtime.class.getDeclaredFields();
        for (Field a:field){
            a.setAccessible(true);
            System.out.println(a);
        }
//        field.setAccessible(true);
//        Runtime o = (Runtime)field.get(rt);
//        o.exec("calc");


    }
}
