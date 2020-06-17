$(document).ready(function () {
    loadCommodity();
});

function deleteCommodity(id) {
    $.post('rest/Commodity/deleteCommodity', {"raavareId":id}, data => alert(JSON.stringify(data)));
}

function loadCommodity() {
    $.post('rest/Product/getCommodityList',
        {},
        function (data, textStatus, req) {
            $("#CommodityTable").empty();
            $.each(data, function (i, elt) {
                $('#CommodityTable').append(generateCommodityTable(elt));
            });
        }
    );
}



function generateCommodityTable(Commodity) {
    return '<tr><td>' + Commodity.raavareId + '</td>' +
        '<td>' +'<input type="text" value="'+Commodity.raavareNavn +'">'+'</td>' +
        '<td>'+'<input type="text" value="' + Commodity.leverandoer + '">'+'</td>' +
        '<td onclick="updateCommodity(' + Commodity.raavareId + ')">opdater raavare</td>' +

        '<td onclick="deleteCommodity(' + Commodity.raavareId + ')"><button>slet raavare</button></td></tr> '



}

function updateCommodity(RaavareId,RaavareNavn,Leverandoer){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO_Final_war_exploded/rest/Commodity/updateCommodity",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"RaavareId":RaavareId,"RaavareNavn":RaavareNavn,"Leverandoer":Leverandoer}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
