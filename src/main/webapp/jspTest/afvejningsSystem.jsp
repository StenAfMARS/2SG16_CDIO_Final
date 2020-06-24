<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/24/2020
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<%@ page import="DTO.ProduktBatchDTO" %>


<body>
<form id="productBatch">
    <label>vælg et productbatch</label>
    <select form="productBatch" name="products" id="Products">
    <%
        ProduktBatchHandler productBatchHandler = new ProduktBatchHandler();
        StringBuilder sb = new StringBuilder();
        for (RaavareBatchDTO raavareBatch : raavareBatches) {
            sb.append(String.format("<option name=\"pbID\"  value=\"%1$s\">%1$s</option>" ,
                    productBatch.getPbID()   // 1
            ));}

        out.print(sb.toString());
    %>
    </select>
</form>
</body>
