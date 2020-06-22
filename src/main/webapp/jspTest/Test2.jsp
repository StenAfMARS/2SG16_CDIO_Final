<html>
    <body>
        <p>
            <%
                String userRole = request.getParameter("userRole");

                out.print(userRole);
            %>
        </p>
    </body>
</html>