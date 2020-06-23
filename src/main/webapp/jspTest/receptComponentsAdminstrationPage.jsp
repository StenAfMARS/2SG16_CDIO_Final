<%@ page import="java.util.List" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<%@ page import="DTO.ProduktBatchKompDTO" %>
<%@ page import="DTO.ReceptKomponentDTO" %>
<%@ page import="Handlers.ReceptHandler" %>
<%
    String keycard = (String)session.getAttribute("sessionUserKeycard");

    if (keycard == null)
        response.sendRedirect("/index.jsp");
    else switch (keycard){
        case "20":
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
        <td id="header" colspan="6" onclick="loadReceptKomponents()"><h1>Table of receptKomponents</h1></td>
    </tr>
    <tr>
        <th>ReceptID</th>
        <th>RaavareBatchID</th>
        <th>Tara</th>
        <th>Netto</th>
        <th>OpretterID</th>
        <th></th>
    </tr>
    <tr>
        <form id="createReceptKomponent"></form>
        <th><input form="createReceptKomponent" type="number" name="pbID"></th>
        <th><input form="createReceptKomponent" type="number" name="rbID"></th>
        <th><input form="createReceptKomponent" type="number" name="tara" step="0.001"></th>
        <th><input form="createReceptKomponent" type="number" name="netto" step="0.001"></th>
        <th><input type="button" value="create" onclick="createReceptKomponent($('#createReceptKomponent'))"></th>
    </tr>
    </thead>
    <tbody id="receptKomponentTable">
    <%
        ReceptHandler receptHandler = new ReceptHandler();

        List<ReceptKomponentDTO> receptKomponents = receptHandler.getReceptKomponentList();

        StringBuilder sb = new StringBuilder();

        for (ReceptKomponentDTO receptKomponent : receptKomponents) {
            sb.append(String.format("<tr id=\"tr%5$s\"><form id=\"%5$s\"></form>" +
                            "<td><input form=\"%5$s\" type=\"number\" name=\"pbID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%5$s\" type=\"number\" name=\"rbID\" value=\"%2$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%5$s\" type=\"number\" name=\"tara\" value=\"%3$s\" step=\"0.001\"></td>" +
                            "<td><input form=\"%5$s\" type=\"number\" name=\"netto\" value=\"%4$s\" step=\"0.001\"></td>" +
                            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponent($(\'#receptKomponentTable #%5$s\'));\"></td></tr>",
                    receptKomponent.getReceptID(),    // 1
                    receptKomponent.getRaavareID(),    // 2
                    receptKomponent.getNonNetto(),    // 3
                    receptKomponent.getTolerance(),   // 4
                    receptKomponent.getReceptID() + "," + receptKomponent.getRaavareID()
            ));}

        out.print(sb.toString());
    %>
    </tbody>
</table>
<script src="/scripts/ReceptComponentsTable.js"></script>

