<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/23/2020
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <form id="loginForm">
        <label>skriv dit bruger id og vælg din rolde</label>
        <input id="UserID" type="text" name="input">
        <div class="wrapper">
            <a onclick="switchPage('../jspTest/LandingPageAdminPanel.jsp?inputName='+document.getElementById('UserID').value+'&keycard=10');setKeycard(10)"><span>Admin</span></a>
            <a onclick="switchPage('../jspTest/LandingPageAdminPanel.jsp?inputName='+document.getElementById('UserID').value+'&keycard=10');setKeycard(20)"><span>Farmaceut</span></a>
            <a onclick="switchPage('../jspTest/LandingPageAdminPanel.jsp?inputName='+document.getElementById('UserID').value+'&keycard=10');setKeycard(30)"><span>Produktionsleder</span></a>
            <a onclick="switchPage('../jspTest/LandingPageAdminPanel.jsp?inputName='+document.getElementById('UserID').value+'&keycard=10');setKeycard(40)"><span>Laborant</span></a>
        </div>

    </form>
</body>

