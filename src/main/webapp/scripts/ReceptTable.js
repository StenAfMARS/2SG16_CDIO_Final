function deleteRecept(id) {
    $.ajax({
        url: '../rest/recepter/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#receptTable #tr' + data).remove();
        }
    });
}


function createRecept(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/recepter',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadRecepter();
        }
    });
}

function loadRecepter() {
    $.get('rest/recepter',
        {},
        function (data, textStatus, req) {
            $("#receptTable").empty();
            $.each(data, function (i, elt) {
                $('#receptTable').append(generateReceptTable(elt));
            });
        }
    );
}


function generateReceptTable(recept) {
    return `<tr id="tr${recept.receptID}"><form id=\"${recept.receptID}\"></form>
        <td><input form=\"${recept.receptID}\" type=\"text\" name=\"userID\" value=\"${recept.receptID}\" readonly=\"readonly\"></td>
        <td><input form=\"${recept.receptID}\" type=\"text\" name=\"userName\" value=\"${recept.receptNavn}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateUser($(\'#userTable #${recept.receptID}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteUser(${recept.receptID});\" value=\"slet\"></td></tr>`;
}

function updateRecept(ReceptID,ReceptNavn){
    var settings = {
        "url": "../rest/recepter",
        "method": "put",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"ReceptID":ReceptID,"ReceptNavn":ReceptNavn}),
    };

    $.ajax(settings).done(function (response) {
        loadRecepter();
    });
}
