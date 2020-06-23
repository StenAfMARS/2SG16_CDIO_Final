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
    String uname=request.getParameter("inputName");
    if(uname != ""){
        session.setAttribute("sessionUserID",uname);
    }
    String ukeyCard=request.getParameter("keycard");
    if(ukeyCard != ""){
        session.setAttribute("sessionUserKeycard",ukeyCard);
    }
    String currentUName=(String)session.getAttribute("sessionUserID");
    String currentUKeycard=(String)session.getAttribute("sessionUserKeycard");
    out.print("velkommen til dit id kort "+ currentUName+ " dit nøglekort nummer er: "+ currentUKeycard);

%>
</body>
