<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/23/2020
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <form>
        <label>skriv dit bruger id og vælg din rolde</label>
        <input id="UserID" type="text" name="input">
        <a href="#" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp?inputName='+document.getElementById('UserID').value+'&keycard=10')"><span>Admin</span></a>
        <a href="#" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><span>Farmaceut</span></a>
        <a href="#" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><span>Produktionsleder</span></a>
        <a href="#" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><span>Laborant</span></a>
        <!--
        <input type="submit" value="Admin" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Farmaceut" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Produktionsleder" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        <input type="submit" value="Laborant" onclick="switchPage('jspTest/LandingPageAdminPanel.jsp')"><br/>
        -->
    </form>
</body>

