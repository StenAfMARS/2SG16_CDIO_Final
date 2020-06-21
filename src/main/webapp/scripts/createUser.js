function createUser() {
    event.preventDefault();
    var data = $('#userForm').serializeJSON();
    $.ajax({
        url: 'rest/user' + document.getElementsByName("id")[0].getAttribute("value"),
        method: 'POST',

        contentType: "application/json", // det vi sender er json
        data: data,
        success: function (data) {
            alert(JSON.stringify(data));

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            alert(textStatus);
            alert(errorThrown);

        }
    });
}