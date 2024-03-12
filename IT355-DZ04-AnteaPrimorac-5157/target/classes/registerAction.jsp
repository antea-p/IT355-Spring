<%@ page import="javax.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");

    if (password != null && password.equals(confirmPassword)) {
        Cookie emailCookie = new Cookie("userEmail", email);
        Cookie passwordCookie = new Cookie("userPassword", password);
        emailCookie.setMaxAge(60 * 60 * 24 * 7);
        passwordCookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(emailCookie);
        response.addCookie(passwordCookie);
        response.sendRedirect("index.jsp");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Passwords do not match.');");
        out.println("location='register.jsp';");
        out.println("</script>");
    }
%>
