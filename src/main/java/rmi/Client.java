package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Hello hello = (Hello) registry.lookup("hellos");

            System.out.println(hello.welcome("axin"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
