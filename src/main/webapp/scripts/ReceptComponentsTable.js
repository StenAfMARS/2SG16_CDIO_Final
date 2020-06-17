$(document).ready(function () {
    loadReceptComponents();
});

function deleteReceptComponents(id) {
    $.post('rest/ReceptComponents/deleteReceptComponents', {"raavareId":id}, data => alert(JSON.stringify(data)));
}

function loadReceptComponents() {
    $.post('rest/ReceptComponents/getReceptComponentsList',
        {},
        function (data, textStatus, req) {
            $("#ReceptComponentsTable").empty();
            $.each(data, function (i, elt) {
                $('#ReceptComponentsTable').append(generateReceptComponentsTable(elt));
            });
        }
    );
}


function generateReceptComponentsTable(ReceptComponents) {
    return '<tr><td>' + ReceptComponents.raavareId + '</td>' +
        '<td>' +'<input type="text" value="'+ReceptComponents.nonNetto +'">'+'</td>' +
        '<td>' +'<input type="text" value="'+ReceptComponents.tolerance +'">'+'</td>' +
        '<td>' +'<input type="text" value="'+ReceptComponents.receptID +'">'+'</td>' +
        '<td onclick="updateReceptComponents(' + ReceptComponents.raavareId + ')">opdater ReceptComponents</td>' +

        '<td onclick="deleteReceptComponents(' + ReceptComponents.raavareId + ')"><button>slet ReceptComponents</button></td></tr> '



        }
