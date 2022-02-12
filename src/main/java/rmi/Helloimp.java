package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Helloimp extends UnicastRemoteObject implements Hello {
    public Helloimp() throws RemoteException {

    }
    @Override
    public String welcome(String name) throws RemoteException {
        return "hello"+name;
    }
}
