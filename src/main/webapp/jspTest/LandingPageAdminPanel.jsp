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
    String uname = (String)request.getAttribute("inputName");


    if(uname != ""){
        session.setAttribute("sessionUserID",uname);
    }

    String ukeyCard=request.getParameter("keycard");

    if(ukeyCard != ""){
        session.setAttribute("sessionUserKeycard",ukeyCard);
    }

    String currentPage=request.getParameter("currentPage");

    if(currentPage != ""){
        session.setAttribute("currentPage",currentPage);
    }

    String currentUName=(String)session.getAttribute("sessname");
    String currentUKeycard=(String)session.getAttribute("sessname");
    out.print("Welcome "+ uname);

%>
</body>
