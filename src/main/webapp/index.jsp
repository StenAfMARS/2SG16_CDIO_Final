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
    <header>
        <img src="images/logo-dummy.png"/>
        <h1>This i a webpage</h1>
        <nav id="navBar">
            <ul>
                <li id="UserPanel"><a href="#" onclick="switchPage('../jspTest/userAdminstrationPage.jsp')">Bruger Administration Panel</a></li>
                <li id="productPanel"><a href="#" onclick="switchPage('../jspTest/productAdminstrationPage.jsp')">Produkt administration Panel</a></li>
                <li id="productComponentsPanel"><a href="#" onclick="switchPage('../jspTest/productComponentsAdminstrationPage.jsp')">product Components Panel</a></li>
                <li id="raavarePanel"><a href="#" onclick="switchPage('../jspTest/raavareadminstrationPage.jsp')">Raavare Panel</a></li>
                <li id="raavareBatchPanel"><a href="#" onclick="switchPage('../jspTest/raavarebatchAdminstrationPage.html')">Raavarebatch Panel</a></li>
                <li id="receptPanel"><a href="#" onclick="switchPage('../jspTest/receptAdminstrationPage.jsp')">Recept Panel</a></li>
                <li id="receptComponentsPanel"><a href="#" onclick="switchPage('../jspTest/raavarebatchAdminstrationPage.html')">recept komboneter Panel</a></li>
            </ul>
        </nav>
    </header>
    <main id="test">

    </main>
    <footer>

    </footer>
    <script>switchPage("../jspTest/LandingPage.jsp");</script>
</body>
</html>
