<%--
  User: Peter Skaarup
  Date: 23-Jun-20

  NOT DONE! DO NOT TRY TO RUN!
  NEEDS TO BE UPDATED WITH CORRECT VALUES AND DATA!!!!!

--%>

<%@ page import="java.util.List" %>
<%@ page import="DTO.ReceptKomponentDTO" %>
<%@ page import="Handlers.ReceptHandler" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>
    <tr>
        <td id="header" colspan="5" onclick="loadReceptKomponentDTO()"><h1>Table of ReceptKomponents</h1></td>
    </tr>
    <tr>
        <th>fk_RaavareID</th>
        <th>fk_ReceptID</th>
        <th>nonNetto</th>
        <th>tolerance</th>

    </tr>
    <tr>
        <form id="createReceptKomponent"></form>
        <th><input form="createReceptKomponent" type="text" name="RaavareID"></th>
        <th><input form="createReceptKomponent" type="text" name="ReceptID"></th>
        <th><input form="createReceptKomponent" type="text" name="nonNetto"></th>
        <th><input form="createReceptKomponent" type="text" name="tolerance"></th>

        <th colspan="2"><input type="button" value="create" onclick="createReceptKomponent($('#createReceptKomponent'))"></th>
    </tr>
    </thead>
    <tbody id="receptKomponentTable">
    <%
        ReceptHandler ReceptHandler = new ReceptHandler();

        List<ReceptKomponentDTO> receptKomponentList = ReceptHandler.getReceptKomponentList();

        StringBuilder sb = new StringBuilder();

        for (ReceptKomponentDTO receptKomponent : receptKomponentList) {
            sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"RaavareID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"ReceptID\" value=\"%2$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"nonNetto\" value=\"%3$s\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"tolerance\" value=\"%4$s\"></td>" +

                            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponents($(\'#ReceptComponentsTable #%1$s\'));\"></td>" +
                            "<td><input type=\"button\" onclick=\"deleteReceptKomponent(%1$s);\" value=\"slet\"></td></tr>",
                    receptKomponent.getRaavareID(),    // 1
                    receptKomponent.getReceptID(),    // 2
                    receptKomponent.getNonNetto(),    // 3
                    receptKomponent.getTolerance()   // 4

            ));}

        out.print(sb.toString());
    %>
    </tbody>
</table>
<script src="/scripts/ReceptComponentsTable.js"></script>

