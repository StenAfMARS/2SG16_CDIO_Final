$(document).ready(function() {
    alert(getCookie(IdCard))
});

$("#logOnForm").submit(function(e) {
    e.preventDefault();
});
function switchPage(page){
    $("main").load(page);
}


function login(keyCardValue) {
    var data = $('#logOnForm').serializeJSON();
    $.ajax({
        url: 'rest/login',
        method: 'POST',

        contentType: "application/json", // det vi sender er json
        data: data,
        success: function (data) {
            alert(JSON.stringify(data));
            var userID =document.getElementById("UserID").value;
            var value = "userID ="+userID+";keyCardValue="+keyCardValue;
            createCookie(IdCard, value, 30)
            switchPage('Views/userAdminstrationPage.html')
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            alert(textStatus);
            alert(errorThrown);
        }
    });
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