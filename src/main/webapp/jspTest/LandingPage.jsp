<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/23/2020
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <form action="LandingPageAdminPanel.jsp">
        <label>skriv dit bruger id og vælg din rolde</label>
        <input type="text" name="input">
        <input type="submit" value="Admin" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Farmaceut" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Produktionsleder" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Laborant" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
    </form>
</body>

