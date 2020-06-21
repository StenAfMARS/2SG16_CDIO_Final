$(document).ready(function() {
    cookieCard()
});

$("#logOnForm").submit(function(e) {
    e.preventDefault();
});
function switchPage(page){
    $("main").load(page);
}
function cookieCard() {

    const idCard = getCookie("CookieCard")
    var keyCard = idCard.split(" ",1)
    if(!getCookie("CookieCard")){
        switchPage('Views/LandingPage.html')
    }
    else if(keyCard== "10")
    {
        alert("test")
        document.getElementById("UserPanel").style.display = "inline-block";
    }
    else if(keyCard== "20"){
        document.getElementById("receptPanel").style.display = "inline-block";
        document.getElementById("receptComponentsPanel").style.display = "inline-block";
        document.getElementById("raavarePanel").style.display = "inline-block";
        document.getElementById("raavareBatchPanel").style.display = "inline-block";
        document.getElementById("productPanel").style.display = "inline-block";
        document.getElementById("productComponentsPanel").style.display = "inline-block";
    }
    else if(keyCard== "30"){
        document.getElementById("raavareBatchPanel").style.display = "inline-block";
        document.getElementById("raavareBatchPanel").style.display = "inline-block";
        document.getElementById("productPanel").style.display = "inline-block";
        document.getElementById("productComponentsPanel").style.display = "inline-block";
    }
    else if(keyCard== "40"){

    }
    else if(keyCard== "100"){
        document.getElementById("UserPanel").style.display = "inline-block";
        document.getElementById("receptPanel").style.display = "inline-block";
        document.getElementById("receptComponentsPanel").style.display = "inline-block";
        document.getElementById("raavarePanel").style.display = "inline-block";
        document.getElementById("raavareBatchPanel").style.display = "inline-block";
        document.getElementById("productPanel").style.display = "inline-block";
        document.getElementById("productComponentsPanel").style.display = "inline-block";
    }
    /*
    switch(keyCard){
        //admin
        case keyCard == "10":
            alert("test")
            document.getElementById("UserPanel").style.display = "inline-block";
            break;
            //farmasøet
        case "20":
            document.getElementById("receptPanel").style.display = "inline-block";
            document.getElementById("receptComponentsPanel").style.display = "inline-block";
            document.getElementById("raavarePanel").style.display = "inline-block";
            document.getElementById("raavareBatchPanel").style.display = "inline-block";
            document.getElementById("productPanel").style.display = "inline-block";
            document.getElementById("productComponentsPanel").style.display = "inline-block";
            break;
            //produktionleder
        case "30":
            document.getElementById("raavareBatchPanel").style.display = "inline-block";
            document.getElementById("raavareBatchPanel").style.display = "inline-block";
            document.getElementById("productPanel").style.display = "inline-block";
            document.getElementById("productComponentsPanel").style.display = "inline-block";
            break;
            //
        case "40":
            break;
            // root access ignore everything
        case "100":
            document.getElementById("UserPanel").style.display = "inline-block";
            document.getElementById("receptPanel").style.display = "inline-block";
            document.getElementById("receptComponentsPanel").style.display = "inline-block";
            document.getElementById("raavarePanel").style.display = "inline-block";
            document.getElementById("raavareBatchPanel").style.display = "inline-block";
            document.getElementById("productPanel").style.display = "inline-block";
            document.getElementById("productComponentsPanel").style.display = "inline-block";

            break;
    }
    alert(keyCard)


     */
}


function login(keyCardValue) {
            var cookieName = "CookieCard";
            var userID =document.getElementById("UserID").value;
            var value = keyCardValue+" "+userID;
            createCookie(cookieName, value, 30)
            alert(getCookie(cookieName))
            switchPage('Views/LandingPageAdminPanel.html')
    // cookieCard insures that you dont get somewhere you not allowed to be
    cookieCard()
}
function createCookie(name, value, minits) {
    var expires;
    if (minits) {
        var date = new Date();
        date.setTime(date.getTime() + (minits * 60 * 1000));
        expires = "; expires=" + date.toGMTString();
    }
    else {
        expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}