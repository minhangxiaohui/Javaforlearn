package fasjsonxxxx;

import java.io.IOException;

public class Thecmd implements  AutoCloseable{
    public Thecmd(String cmd){
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void close() throws Exception {

    }
}
