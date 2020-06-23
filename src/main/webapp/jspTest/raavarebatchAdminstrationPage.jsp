<%@ page import="Handlers.RaavareBatchHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.RaavareBatchDTO" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>
    <tr>
        <td id="header" colspan="8" onclick="loadRaavareBatches()"><h1>Table of raavareBatches</h1></td>
    </tr>
    <tr>
        <th>RaavareBatchId</th>
        <th>raavareID</th>
        <th>maengde</th>
        <th></th>
    </tr>
    <tr>
        <form id="createRaavareBatch"></form>
        <th><input form="createRaavareBatch" type="text" name="rbID"></th>
        <th><input form="createRaavareBatch" type="text" name="raavareID"></th>
        <th><input form="createRaavareBatch" type="text" name="maengde" step="0.001"></th>
        <th><input type="button" value="create" onclick="createRaavareBatch($('#createRaavareBatch'))"></th>
    </tr>
    </thead>
    <tbody id="raavareBatchTable">
    <%
    RaavareBatchHandler raavareBatchHandler = new RaavareBatchHandler();

    List<RaavareBatchDTO> raavareBatches = raavareBatchHandler.getRaavareBatchList();

        StringBuilder sb = new StringBuilder();

        for (RaavareBatchDTO raavareBatch : raavareBatches) {
        sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
            "<td><input form=\"%1$s\" type=\"number\" name=\"rbID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
            "<td><input form=\"%1$s\" type=\"number\" name=\"raavareID\" value=\"%2$s\"></td>" +
            "<td><input form=\"%1$s\" type=\"number\" name=\"maengde\" value=\"%3$s\" step=\"0.001\"></td>" +
            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateRaavareBatch($(\'#raavareBatchTable #%1$s\'));\"></td></tr>",
            raavareBatch.getRbID(),     // 1
            raavareBatch.getRaavareID(),// 2
            raavareBatch.getMaengde()   // 3
        ));}

        out.print(sb.toString());
        %>
    </tbody>
</table>
<script src="/scripts/RaavareBatchTable.js"></script>

