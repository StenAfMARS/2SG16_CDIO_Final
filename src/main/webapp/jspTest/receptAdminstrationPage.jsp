<%@ page import="Handlers.UserHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.UserDTO" %>
<%@ page import="Handlers.ReceptHandler" %>
<%@ page import="DTO.ReceptDTO" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>
    <tr>
        <td id="header" colspan="4" onclick="loadUsers()"><h1>Table of recepter</h1></td>
    </tr>
    <tr>
        <th>receptID</th>
        <th>receptNavn</th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <form id="createUser" method="post" action="/rest/recepter"></form>
        <th><input form="createUser" type="text" name="receptID"></th>
        <th><input form="createUser" type="text" name="receptNavn"></th>
        <th colspan="2"><input type="button" value="create" onclick="createUser($('#createRecept'))"></th>
    </tr>
    </thead>
    <tbody id="receptTable">
    <%
    ReceptHandler receptHandler = new ReceptHandler();

    List<ReceptDTO> recepter = receptHandler.getReceptList();

        StringBuilder sb = new StringBuilder();

        for (ReceptDTO recept : recepter) {
        sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
            "<td><input form=\"%1$s\" type=\"text\" name=\"receptID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
            "<td><input form=\"%1$s\" type=\"text\" name=\"receptNavn\" value=\"%2$s\"></td>" +
            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateRecept($(\'#receptTable #%1$s\'));\"></td>" +
            "<td><input type=\"button\" onclick=\"deleteRecept(%1$s);\" value=\"slet\"></td></tr>",
        recept.getReceptID(),   // 1
        recept.getReceptNavn()  // 2
        ));}

        out.print(sb.toString());
        %>
    </tbody>
</table>
<script src="/scripts/ReceptTable.js"></script>

