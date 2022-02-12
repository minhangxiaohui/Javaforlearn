import java.io.IOException;

public class BadObject {

    public BadObject() {
        String cmd ="calc";
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
//            Runtime.getRuntime().exec("calc");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

