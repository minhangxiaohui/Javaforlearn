
public class Evalforcalc {
    public Evalforcalc() {

    }

    static {
        try {
            Process ps = Runtime.getRuntime().exec("calc");
            ps.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
