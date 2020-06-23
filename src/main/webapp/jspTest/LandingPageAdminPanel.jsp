<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/23/2020
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<%
    String uname=request.getParameter("inputname");
    out.print("Welcome "+ uname);
    session.setAttribute("sessionname",uname);
%>
</body>
