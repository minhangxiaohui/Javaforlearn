import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        ServerSocket  ssoc = null;
        try {
            ssoc = new ServerSocket(Integer.parseInt("9999"));
            System.out.println("server open on prot"+ssoc.getLocalPort());
            while (true){
                Socket socket = ssoc.accept();
                System.out.println("server receive connect from"+socket.getInetAddress());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object object = null;
                try {
                    object = ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Read Object"+object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
