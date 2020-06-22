<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/22/2020
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Handlers.UserHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.RaavareDTO" %>
<%@ page import="Handlers.RaavareHandler" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>

    <tr>
        <td id="header" colspan="7"><h1>Råvare table</h1> </td>

    </tr>

    <tr>
        <th>RaavareId</th>
        <th>RaavareNavn</th>
        <th>Leverandoer</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    <tr>
        <form id="createRaavare" method="post" action="/rest/users">
            <th></th>
            <th><input type="text" name="RaavareNavn"></th>
            <th colspan="2"><input type="button" value="create" onclick="createRaavare($('#createRaavare'))"></th>
        </form>
    </tr>

    </thead>
    <tbody id="commodityBatchTable">
    <%
        RaavareHandler RaavareHandler = new RaavareHandler();

        List<RaavareDTO> raavare = RaavareHandler.getRaavareList();

        StringBuilder sb = new StringBuilder();

        for (RaavareDTO user : raavare) {
            sb.append("<form method='put' action='/rest/raavare'><tr id='");
            sb.append(user.get());
            sb.append("'><td name='userID' value='");
            sb.append(user.getUserID());
            sb.append("'>");
            sb.append(user.getUserID());
            sb.append("</td>");
            sb.append("<td><input type='text' name='userName' value='");
            sb.append(user.getUserName());
            sb.append("'></td><td><input type='text' name='ini' value='");
            sb.append(user.getIni());
            sb.append("'></td><td><input type='text' name='cpr' value='");
            sb.append(user.getCpr());
            sb.append("'></td><td><input type='text' name='password' value='");
            sb.append(user.getPassword());
            sb.append("'></td><td><input type='text' name='roles' value='");
            sb.append(user.getRoles());
            sb.append("'></td><td><input type='button' value='opdater'></td><td><input type='button' onclick='deleteUser(");
            sb.append(user.getUserID());
            sb.append(")' value='slet'></td></tr></form>");
        }

        out.print(sb.toString());
    %>
    </tbody>
</table>
</body>