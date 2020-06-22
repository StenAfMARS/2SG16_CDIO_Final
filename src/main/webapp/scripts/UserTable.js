$(document).ready(function () {
    loadUsers();
});

function deleteUser(id) {
    $.delete('rest/user/' + id, null, data => alert(JSON.stringify(data)));
}

function loadUsers() {
    $.get('rest/users',
        {},
        function (data, textStatus, req) {
            $("#userTable").empty();
            $.each(data, function (i, elt) {
                $('#userTable').append(generateUserTable(elt));
            });
        }
    );
}

function generateUserTable(user) {
    return '<tr><td>' + user.userID + '</td>' +
        '<td>' +'<input type="text" value="'+user.userName +'">'+'</td>' +
        '<td>'+'<input type="text" value="' + user.ini + '">'+'</td>' +
        '<td>' +'<input type="text" value="' +user.cpr + '">'+'</td>' +
        '<td>'+'<input type="text" value="' + user.password + '">'+'</td>' +
        '<td>' +'<input type="text" value="' + user.roles + '">'+' </td>' +
        '<td onclick="updateUser(' + user.userID + ')">opdater bruger</td>' +

        '<td onclick="deleteUser(' + user.userID + ')"><button>slet bruger</button></td></tr> '
}

function updateUserByID(id){
    switchPage("Views/userAdminstrationPage.html");
    document.uuuuserID = id;
}

function updateUser(id,userName,password,ini,cpr,roles){
    var settings = {
        "url": "/rest/user/" + id,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"userID":id,"userName":userName,"password":password,"ini":ini,"cpr":cpr,"roles":roles}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
