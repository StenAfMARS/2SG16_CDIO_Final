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
            <th>update</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody id="userTable">
        <%
            UserHandler userHandler = new UserHandler();

            List<UserDTO> users = userHandler.getUserList();

            for (UserDTO user : users) {
                out.print(
                "<tr><td>" + user.getUserID() + "</td>" +
                "<td><input type='text' value='" + user.getUserName() + "'></td>" +
                "<td><input type='text' value='" + user.getIni() + "'></td>" +
                "<td><input type='text' value='" +user.getCpr() + "'></td>" +
                "<td><input type='text' value='" + user.getPassword() + "'></td>" +
                "<td><input type='text' value='" + user.getRoles() + "'></td>" +
                "<td onclick='updateUser(" + user.getUserID() + ")'><button>opdater bruger</button></td>" +
                "<td onclick='deleteUser(" + user.getUserID() + ")'><button>slet bruger</button></td></tr>");
            }
        %>
    </tbody>
</table>

