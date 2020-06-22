function deleteUser(id) {
    $.ajax({
        url: '../rest/users/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#userTable #tr' + data).remove();
        }
    });
}

function createUser(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/users',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadUsers();
        }
    });
}

function loadUsers() {
    $.get('../rest/users',
        {},
        function (data, textStatus, req) {
            $("#userTable").empty();
            $.each(data, function (i, elt) {
                $('#userTable').append(addUserOnTable(elt));
            });
        }
    );
}

function addUserOnTable(user) {
    return `<tr id="tr${user.userID}"><form id=\"${user.userID}\"></form>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"userID\" value=\"${user.userID}\" readonly=\"readonly\"></td>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"userName\" value=\"${user.userName}\"></td>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"ini\" value=\"${user.ini}\"></td>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"cpr\" value=\"${user.cpr}\"></td>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"password\" value=\"${user.password}\"></td>
        <td><input form=\"${user.userID}\" type=\"text\" name=\"roles\" value=\"${user.roles}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateUser($(\'#userTable #${user.userID}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteUser(${user.userID});\" value=\"slet\"></td></tr>`;
}

function updateUser(form){
    var settings = {
        "url": "../rest/users",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadUsers();
    });
}
