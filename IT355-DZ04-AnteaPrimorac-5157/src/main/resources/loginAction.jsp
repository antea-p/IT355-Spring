<%@ page import="javax.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    boolean isAuthenticated = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("userEmail".equals(cookie.getName()) && email.equals(cookie.getValue())) {
                for (Cookie pwdCookie : cookies) {
                    if ("userPassword".equals(pwdCookie.getName()) && password.equals(pwdCookie.getValue())) {
                        isAuthenticated = true;
                        break;
                    }
                }
            }
        }
    }

    if (isAuthenticated) {
        response.sendRedirect("home.jsp");
    } else {
        response.sendRedirect("login.jsp?error=true");
    }
%>
