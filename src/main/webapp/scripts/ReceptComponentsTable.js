$(document).ready(function () {
    loadReceptComponents();
});

function deleteReceptComponents(id) {
    $.post('rest/ReceptComponents/deleteReceptComponents', {"raavareId":id}, data => alert(JSON.stringify(data)));
}

function loadReceptComponents() {
    $.post('rest/ReceptComponents/getReceptKomponentsList',
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
function updateReceptComponents(RaavareId,NonNetto,Tolerance,ReceptID){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO_Final_war_exploded/rest/ReceptComponents/updateReceptComponents",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"RaavareId":RaavareId,"NonNetto":NonNetto,"Tolerance":Tolerance,"ReceptID":ReceptID}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
