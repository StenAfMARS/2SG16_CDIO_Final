<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/22/2020
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="DTO.RaavareDTO" %>
<%@ page import="Handlers.RaavareHandler" %>
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
        <td id="header" colspan="5"><h1>Råvare table</h1> </td>

    </tr>

    <tr>
        <th>RaavareId</th>
        <th>RaavareNavn</th>
        <th>Leverandoer</th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <form id="createRaavare">
            <th></th>
            <th><input form="createRaavare" type="text" name="raavareNavn"></th>
            <th><input form="createRaavare" type="text" name="leverandoer"></th>
            <th colspan="2"><input type="button" value="create" onclick="createCommodity($('#createRaavare'))"></th>
        </form>
    </tr>

    </thead>
    <tbody id="commodityBatchTable">
    <%
        RaavareHandler RaavareHandler = new RaavareHandler();

        List<RaavareDTO> raavare = RaavareHandler.getRaavareList();

        StringBuilder sb = new StringBuilder();

        for (RaavareDTO raavareDTO : raavare) {
            sb.append(String.format("<tr id=\"tr%1$s\"><form id=\"%1$s\"></form>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"raavareID\" value=\"%1$s\" readonly=\"readonly\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"raavareNavn\" value=\"%2$s\"></td>" +
                            "<td><input form=\"%1$s\" type=\"text\" name=\"raavareLeverandoer\" value=\"%3$s\"></td>" +
                            "<td><input type=\"button\" value=\"opdater\" onclick=\"updateCommodity($(\'#commodityBatchTable #%1$s\'));\"></td>" +
                            "<td><input type=\"button\" onclick=\"deleteCommodity(%1$s);\" value=\"slet\"></td></tr>",
                    raavareDTO.getRaavareID(),      // 1
                    raavareDTO.getRaavareNavn(),    // 2
                    raavareDTO.getLeverandoer()     // 3
                )
            );

        }
        out.print(sb.toString());
    %>
    </tbody>
</table>
<script src="../scripts/RaavareTable.js"></script>