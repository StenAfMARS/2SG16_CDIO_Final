<html>
<head>
    <meta charset="UTF-8">
    <title>Single Page</title>
    <link rel="stylesheet" href="css/mainStyle.css">
    <script src="scripts/jquery-3.4.1.js"></script>
    <script src="scripts/jquery.serialize-object.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>
 <%
     // session controller
     String currentUName=(String)session.getAttribute("sessionUserID");

    if(currentUName == ""){
        String switchPageCommand = "<script>switchPage(\"jspTest/LandingPage.jsp\");</script>";
    }

 %>
    <header>
        <img src="images/logo-dummy.png"/>
        <h1>This i a webpage</h1>
        <nav id="navBar">
            <ul><%
                String userPanel = "<li id=\"UserPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/userAdminstrationPage.jsp')\">Bruger Administration Panel</a></li>";
                String productPanel = "<li id=\"productPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/productAdminstrationPage.jsp')\">Produkt administration Panel</a></li>";
                String productComponentsPanel = "<li id=\"productComponentsPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/productComponentsAdminstrationPage.jsp')\">product Components Panel</a></li>";
                String raavarePanel = "<li id=\"raavarePanel\"><a href=\"#\" onclick=\"switchPage('jspTest/raavareadminstrationPage.jsp')\">Raavare Panel</a></li>\n";
                String raavareBatchPanel = "<li id=\"raavareBatchPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/raavarebatchAdminstrationPage.html')\">Raavarebatch Panel</a></li>";
                String receptPanel = "<li id=\"receptPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/receptAdminstrationPage.jsp')\">Recept Panel</a></li>";
                String receptComponentsPanel = "<li id=\"receptComponentsPanel\"><a href=\"#\" onclick=\"switchPage('jspTest/raavarebatchAdminstrationPage.html')\">recept komboneter Panel</a></li>";

                String currentUKeycard=(String)session.getAttribute("sessionUserKeycard");
                StringBuilder sb = new StringBuilder();
                if(currentUKeycard != null) {
                    switch (currentUKeycard) {
                        case "10":
                            sb.append(userPanel);

                            break;
                        case "20":
                            sb.append(raavarePanel);
                            sb.append(raavareBatchPanel);
                            sb.append(receptPanel);
                            sb.append(receptComponentsPanel);
                            sb.append(productPanel);
                            sb.append(productComponentsPanel);
                        /*
                        out.print(raavarePanel);
                        out.print(raavareBatchPanel);

                        out.print(receptPanel);
                        out.print(receptComponentsPanel);

                        out.print(productPanel);
                        out.print(productComponentsPanel);
                        */
                            break;

                        case "30":
                            sb.append(raavarePanel);
                            sb.append(raavareBatchPanel);
                            sb.append(productPanel);
                            sb.append(productComponentsPanel);
                        /*
                        out.print(raavarePanel);
                        out.print(raavareBatchPanel);

                        out.print(productPanel);
                        out.print(productComponentsPanel);
                        */
                            break;

                    }
                    out.print(sb.toString());

                }
            %></ul>
        </nav>
    </header>
    <main id="test">




    </main>
    <footer>

    </footer>
    <script>switchPage("jspTest/LandingPage.jsp");</script>
</body>
</html>
