<%--
  Created by IntelliJ IDEA.
  User: Peter Skaarup
  Date: 23-Jun-20
  Time: 13:22
  NEEDS TO BE UPDATED WITH CORRECT VALUES AND DATA!!!!!
  NOT DONE! DO NOT TRY TO RUN!
--%>

<%@ page import="java.util.List" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<%@ page import="DTO.ReceptKomponentDTO" %>
<%@ page import="DTO.ReceptDTO" %>
<%@ page import="DTO.RaavareDTO" %>
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
        <th></th>
        <th></th>
    </tr>
    <tr>
        <form id="createReceptKomponent"></form>
        <th><input form="createReceptKomponent" type="text" name="fk_RaavareID"></th>
        <th><input form="createReceptKomponent" type="text" name="fk_ReceptID"></th>
        <th><input form="createReceptKomponent" type="text" name="nonNetto"></th>
        <th><input form="createReceptKomponent" type="text" name="tolerance"></th>

        <th colspan="2"><input type="button" value="create" onclick="createReceptKomponent($('#createReceptKomponent'))"></th>
    </tr>
    </thead>
    <tbody id="productBatchKomponentTable">
    <%
        ReceptHandler ReceptHandler = new ReceptHandler();

        List<ReceptKomponentDTO> recepthKomponents = ReceptHandler.getReceptKomponentList();

        StringBuilder sb = new StringBuilder();

        for (receptKomponents receptKomponent : receptKomponents) {
            sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"pbID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"rbID\" value=\"%2$s\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"tara\" value=\"%3$s\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"netto\" value=\"%4$s\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"oprID\" value=\"%5$s\"></td>" +
                            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatchKomponent($(\'#productBatchTable #%1$s\'));\"></td>" +
                            "<td><input type=\"button\" onclick=\"deleteProductBatchKomponent(%1$s);\" value=\"slet\"></td></tr>",
                    recepthKomponents.get,    // 1
                    productBatchKomponent.getRbID(),    // 2
                    productBatchKomponent.getTara(),    // 3
                    productBatchKomponent.getNetto(),   // 2
                    productBatchKomponent.getOprID()    // 3
            ));}

        out.print(sb.toString());
    %>
    </tbody>
</table>
<script src="/scripts/ProductComponentsTable.js"></script>

