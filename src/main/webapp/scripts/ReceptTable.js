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
    $.get('../rest/recepter',
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
        <td><input form=\"${recept.receptID}\" type=\"text\" name=\"receptID\" value=\"${recept.receptID}\" readonly=\"readonly\"></td>
        <td><input form=\"${recept.receptID}\" type=\"text\" name=\"receptName\" value=\"${recept.receptNavn}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateRecept($(\'#receptTable #${recept.receptID}\'));\"></td></tr>`;
}

function updateRecept(form){
    var settings = {
        "url": "../rest/recepter",
        "method": "put",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON(),
    };

    $.ajax(settings).done(function (response) {
        loadRecepter();
    });
}
