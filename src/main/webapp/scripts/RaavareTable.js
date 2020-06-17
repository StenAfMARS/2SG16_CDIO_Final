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