<%@ page import="java.util.List" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<%@ page import="DTO.ProduktBatchDTO" %>
<%
    String keycard = (String)session.getAttribute("sessionUserKeycard");

    if (keycard == null)
        response.sendRedirect("/index.jsp");
    else switch (keycard){
        case "20":
        case "30":
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
        <td id="header" colspan="5" onclick="loadProductBatches()"><h1>Table of productBatches</h1></td>
    </tr>
    <tr>
        <th>ProductBatchId</th>
        <th>status</th>
        <th>receptID</th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <form id="createProductBatch"></form>
        <th><input form="createProductBatch" type="text" name="pbID"></th>
        <th><input form="createProductBatch" type="text" name="status"></th>
        <th><input form="createProductBatch" type="text" name="receptID"></th>
        <th colspan="2"><input type="button" value="create" onclick="createProductBatch($('#createProductBatch'))"></th>
    </tr>
    </thead>
    <tbody id="productBatchTable">
    <%
        ProduktBatchHandler productBatchHandler = new ProduktBatchHandler();

        List<ProduktBatchDTO> productBatches = productBatchHandler.getProduktBatchList();

        StringBuilder sb = new StringBuilder();

        for (ProduktBatchDTO productBatch : productBatches) {
            sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
            "<td><input form=\"%1$s\" type=\"text\" name=\"pbID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
            "<td><input form=\"%1$s\" type=\"text\" name=\"status\" value=\"%2$s\"></td>" +
            "<td><input form=\"%1$s\" type=\"text\" name=\"receptID\" value=\"%3$s\"></td>" +
            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatch($(\'#productBatchTable #%1$s\'));\"></td>" +
            "<td><input type=\"button\" onclick=\"deleteProductBatch(%1$s);\" value=\"slet\"></td></tr>",
            productBatch.getPbID(),   // 1
            productBatch.getStatus(), // 2
            productBatch.getReceptID()// 3
        ));}

        out.print(sb.toString());
        %>
    </tbody>
</table>
<script src="/scripts/ProductTable.js"></script>

