<%@ page import="Handlers.UserHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.UserDTO" %>

<%
    String keycard = (String)session.getAttribute("sessionUserKeycard");

    if (keycard == null)
        response.sendRedirect("/index.jsp");
    else switch (keycard){
        case "10":
        case "100":
            break;
        default:
            response.setStatus(403);
    }
%>

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
        <tr>
            <form id="createUser"></form>
            <th></th>
            <th><input form="createUser" type="text" name="userName"></th>
            <th><input form="createUser" type="text" name="ini"></th>
            <th><input form="createUser" type="number" name="cpr"></th>
            <th><input form="createUser" type="text" name="password"></th>
            <th><input form="createUser" type="text" name="roles"></th>
            <th colspan="2"><input type="button" value="create" onclick="createUser($('#createUser'))"></th>
        </tr>
    </thead>
    <tbody id="userTable">
        <%
            UserHandler userHandler = new UserHandler();

            List<UserDTO> users = userHandler.getUserList();

            StringBuilder sb = new StringBuilder();

            for (UserDTO user : users) {
                sb.append(String.format("<tr keycard=\"tr%1$s\"><form keycard=\"%1$s\"></form>" +
                    "<td><input form=\"%1$s\" type=\"number\" name=\"userID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
                    "<td><input form=\"%1$s\" type=\"text\" name=\"userName\" value=\"%2$s\"></td>" +
                    "<td><input form=\"%1$s\" type=\"text\" name=\"ini\" value=\"%3$s\"></td>" +
                    "<td><input form=\"%1$s\" type=\"number\" name=\"cpr\" value=\"%4$s\"></td>" +
                    "<td><input form=\"%1$s\" type=\"text\" name=\"password\" value=\"%5$s\"></td>" +
                    "<td><input form=\"%1$s\" type=\"text\" name=\"roles\" value=\"%6$s\"></td>" +
                    "<td><input type=\"button\" value=\"opdater\" onclick=\"updateUser($(\'#userTable #%1$s\'));\"></td>" +
                    "<td><input type=\"button\" onclick=\"deleteUser(%1$s);\" value=\"slet\"></td></tr>",
                        user.getUserID(),   // 1
                        user.getUserName(), // 2
                        user.getIni(),      // 3
                        user.getCpr(),      // 4
                        user.getPassword(), // 5
                        user.getRoles()));  // 6
            }

            out.print(sb.toString());
        %>
    </tbody>
</table>
<script src="/scripts/UserTable.js"></script>

