$(document).ready(function () {
    loadRecept();
});

function deleteRecept(id) {
    $.post('rest/Recept/deleteRecept', {"receptID":id}, data => alert(JSON.stringify(data)));
}

function loadRecept() {
    $.post('rest/Recept/getReceptList',
        {},
        function (data, textStatus, req) {
            $("#ReceptTable").empty();
            $.each(data, function (i, elt) {
                $('#ReceptTable').append(generateReceptTable(elt));
            });
        }
    );
}


function generateReceptTable(Recept) {
    return '<tr><td>' + Recept.receptID + '</td>' +
        '<td>' +'<input type="text" value="'+Recept.receptNavn +'">'+'</td>' +
        '<td onclick="updateRecept(' + Recept.receptID + ')">opdater Recept</td>' +

        '<td onclick="deleteRecept(' + Recept.receptID + ')"><button>slet Recept</button></td></tr> '



}

