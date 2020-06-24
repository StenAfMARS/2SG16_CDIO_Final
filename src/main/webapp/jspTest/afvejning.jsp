<%--
  Created by IntelliJ IDEA.
  User: mathias
  Date: 6/24/2020
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Handlers.ProduktBatchHandler" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="../scripts/jquery-3.4.1.js"></script>
<script src="../scripts/jquery.serialize-object.js"></script>
<script src="../scripts/afvejning.js"></script>

<body>
    <form id="productBatch">
        <label>vælg et productbatch</label>
        <select form="productBatch" name="products" id="Products">
            <%
                ProduktBatchHandler productBatchHandler = new ProduktBatchHandler();
                Integer[] productList = productBatchHandler.getProduktBatchListOfUnfinishedProducts();
                StringBuilder sb = new StringBuilder();
                for (Integer product : productList) {
                    sb.append(String.format("<option name=\"pbID\"  value=\"%1$s\">%1$s</option>" ,
                            product   // 1
                    ));}

                out.print(sb.toString());
            %>
        </select>
        <a href="#" onclick="sendID()">vælg produkt</a>
    </form>
    <table align="center">
        <thead>
        <tr>
            <td id="header" colspan="6" onclick="loadReceptKomponents()"><h1>Table of receptKomponents needed for the recept</h1></td>
        </tr>
        <tr>
            <th>receptID</th>
            <th>raavareID</th>
            <th>nonNetto</th>
            <th>tolerance</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="receptKomponentTable">
        </tbody>
    </table>
    <form id="afvejning">
        <label>indtast tara</label>
        <input form="afvejning" name="tara" type="number" step="any">
        <label>indtast netto</label>
        <input form="afvejning" name="netto" type="number" step="any">
        <a href="#" onclick="sendID()">afregn</a>
    </form>
</body>
</html>
