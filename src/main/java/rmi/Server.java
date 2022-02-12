package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Hello hello = new Helloimp();
            Registry registry = LocateRegistry.createRegistry(1099);
            // 绑定对象到注册表，并给他取名为hello
            registry.rebind("hellos",hello);
            System.out.println("open port for rmi for 1099:hellos");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
