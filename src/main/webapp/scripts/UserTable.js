$(document).ready(function () {
    loadUsers();
});

function deleteUser(id) {
    $.post('rest/user/deleteUser', {"userID":id}, data => alert(JSON.stringify(data)));
}

function loadUsers() {
    $.post('rest/user/getUserList',
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