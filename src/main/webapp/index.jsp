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
        <img src="images/64249527_1562248023929254_8289038434601795584_o.jpg"/>

        <nav id="navBar">
            <ul>
                <li id="UserPanel" class="kc10 kc100 kc">
                    <a onclick="switchPage('../jspTest/userAdminstrationPage.jsp')">
                        Bruger Administration Panel
                    </a>
                </li>
                <li id="productPanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/productAdminstrationPage.jsp')">
                        Produkt administration Panel
                    </a>
                </li>
                <li id="productComponentsPanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/productComponentsAdminstrationPage.jsp')">
                        product Components Panel
                    </a>
                </li>
                <li id="raavarePanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/raavareAdminstrationPage.jsp')">
                        Raavare Panel
                    </a>
                </li>
                <li id="raavareBatchPanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/raavarebatchAdminstrationPage.jsp')">
                        Raavarebatch Panel
                    </a>
                </li>
                <li id="receptPanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/receptAdminstrationPage.jsp')">
                        Recept Panel
                    </a>
                </li>
                <li id="receptComponentsPanel" class="kc20 kc30 kc100 kc">
                    <a onclick="switchPage('../jspTest/receptComponentsAdminstrationPage.jsp')">
                        recept komboneter Panel
                    </a>
                </li>
                <li id="receptComponentsPanel" class="kc30 kc40 kc100 kc">
                    <a onclick="switchPage('../jspTest/afvejning.jsp')">
                        afvejnings system
                    </a>
                </li>
            </ul>
        </nav>
    </header>
    <main id="test">




    </main>
    <footer>
    <style id="kcController">
    </style>
    </footer>
    <script>switchPage("../jspTest/LandingPage.jsp");</script>
</body>
</html>
