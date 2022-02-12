package test;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

public class Xutuil {
    public static void main(String[] args) {

        Method[] methods = ReflectUtil.getMethods(java.lang.String.class);
        String a = "";
        for (Method m :methods) {
            System.out.println(m.toString());
        }
        String x =new String(new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 82, 117, 110, 116, 105, 109, 101});
        System.out.println(x);
        System.out.println(String.class.getClass());
        System.out.println(new String(new byte[]{103, 101, 116, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109}));


    }
}
