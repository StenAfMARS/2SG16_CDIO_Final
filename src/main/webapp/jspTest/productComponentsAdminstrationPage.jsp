<%@ page import="java.util.List" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<%@ page import="DTO.ProduktBatchKompDTO" %>
<script src="/scripts/jquery-3.4.1.js"></script>
<script src="/scripts/jquery.serialize-object.js"></script>
<table align="center">
    <thead>
    <tr>
        <td id="header" colspan="6" onclick="loadProductBatchKomponents()"><h1>Table of productBatchKomponents</h1></td>
    </tr>
    <tr>
        <th>ProductBatchID</th>
        <th>RaavareBatchID</th>
        <th>Tara</th>
        <th>Netto</th>
        <th>OpretterID</th>
        <th></th>
    </tr>
    <tr>
        <form id="createProductBatchKomponent"></form>
        <th><input form="createProductBatchKomponent" type="number" name="pbID"></th>
        <th><input form="createProductBatchKomponent" type="number" name="rbID"></th>
        <th><input form="createProductBatchKomponent" type="number" name="tara" step="0.001"></th>
        <th><input form="createProductBatchKomponent" type="number" name="netto" step="0.001"></th>
        <th><input form="createProductBatchKomponent" type="number" name="oprID"></th>
        <th><input type="button" value="create" onclick="createProductBatchKomponent($('#createProductBatchKomponent'))"></th>
    </tr>
    </thead>
    <tbody id="productBatchKomponentTable">
    <%
    ProduktBatchHandler productBatchHandler = new ProduktBatchHandler();

    List<ProduktBatchKompDTO> productBatchKomponents = productBatchHandler.getproduktBatchKompDTOList();

        StringBuilder sb = new StringBuilder();

        for (ProduktBatchKompDTO productBatchKomponent : productBatchKomponents) {
        sb.append(String.format("<tr id=\"tr%6$s\"><form id=\"%6$s\"></form>" +
            "<td><input form=\"%6$s\" type=\"number\" name=\"pbID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
            "<td><input form=\"%6$s\" type=\"number\" name=\"rbID\" value=\"%2$s\" readonly=\"readonly\"></td>" +
            "<td><input form=\"%6$s\" type=\"number\" name=\"tara\" value=\"%3$s\" step=\"0.001\"></td>" +
            "<td><input form=\"%6$s\" type=\"number\" name=\"netto\" value=\"%4$s\" step=\"0.001\"></td>" +
            "<td><input form=\"%6$s\" type=\"number\" name=\"oprID\" value=\"%5$s\"></td>" +
            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatchKomponent($(\'#productBatchKomponentTable #%6$s\'));\"></td></tr>",
            productBatchKomponent.getPbID(),    // 1
            productBatchKomponent.getRbID(),    // 2
            productBatchKomponent.getTara(),    // 3
            productBatchKomponent.getNetto(),   // 4
            productBatchKomponent.getOprID(),   // 5
            productBatchKomponent.getPbID() + "," + productBatchKomponent.getRbID()
            ));}

        out.print(sb.toString());
        %>
    </tbody>
</table>
<script src="/scripts/ProductComponentsTable.js"></script>

