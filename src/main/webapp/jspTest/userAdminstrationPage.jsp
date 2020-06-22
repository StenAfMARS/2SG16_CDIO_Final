<%@ page import="Handlers.UserHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.UserDTO" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>
        <tr>
            <td id="header" colspan="8" onclick="loadUsers()"><h1>Table of users</h1></td>
        </tr>
        <tr>
            <th>UserId</th>
            <th>UserName</th>
            <th>Initialer</th>
            <th>CPR</th>
            <th>Password</th>
            <th>Roles</th>
            <th></th>
            <th></th>
        </tr>
        <tr><form id="createUser" method="post" action="/rest/users">
            <th></th>
            <th><input type="text" name="userName"></th>
            <th><input type="text" name="ini"></th>
            <th><input type="text" name="cpr"></th>
            <th><input type="text" name="password"></th>
            <th><input type="text" name="roles"></th>
            <th colspan="2"><input type="button" value="create" onclick="createUser($('#createUser'))"></th>
        </form></tr>
    </thead>
    <tbody id="userTable">
        <%
            UserHandler userHandler = new UserHandler();

            List<UserDTO> users = userHandler.getUserList();

            StringBuilder sb = new StringBuilder();

            for (UserDTO user : users) {
                sb.append("<form method='put' action='/rest/users'><tr id='");
                sb.append(user.getUserID());
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
<script src="/scripts/UserTable.js"></script>

