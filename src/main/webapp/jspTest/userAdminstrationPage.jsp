<%@ page import="Handlers.UserHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.UserDTO" %>
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
        <tr><form method="post" action="/rest/users">
            <th>UserId</th>
            <th><input type="text" name="userName"></th>
            <th><input type="text" name="ini"></th>
            <th><input type="text" name="cpr"></th>
            <th><input type="text" name="password"></th>
            <th><input type="text" name="roles"></th>
            <th colspan="8"><input type="button" value="create"></th>
        </form></tr>
    </thead>
    <tbody id="userTable">
        <%
            UserHandler userHandler = new UserHandler();

            List<UserDTO> users = userHandler.getUserList();

            for (UserDTO user : users) {
                out.print(
                "<tr><form method='put' action='/rest/users'>" +
                "<td name='userID' value='" + user.getUserID() + "'>" + user.getUserID() + "</td>" +
                "<td><input type='text' name='userName' value='" + user.getUserName() + "'></td>" +
                "<td><input type='text' name='ini' value='" + user.getIni() + "'></td>" +
                "<td><input type='text' name='cpr' value='" +user.getCpr() + "'></td>" +
                "<td><input type='text' name='password' value='" + user.getPassword() + "'></td>" +
                "<td><input type='text' name='roles' value='" + user.getRoles() + "'></td>" +
                "<td><input type='button' value='opdater'></td>" +
                "<td onclick='deleteUser(" + user.getUserID() + ")'><button>slet</button></td></form></tr>");
            }
        %>
    </tbody>
</table>

