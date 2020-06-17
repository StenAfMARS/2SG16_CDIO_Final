$(document).ready(function () {
    loadCommodityBatch();
});

function deleteCommodityBatch(id) {
    $.post('rest/CommodityBatch/deleteCommodityBatch', {"rbId":id}, data => alert(JSON.stringify(data)));
}

function loadProductComponents() {
    $.post('rest/CommodityBatch/getCommodityBatchsList',
        {},
        function (data, textStatus, req) {
            $("#CommodityBatchTable").empty();
            $.each(data, function (i, elt) {
                $('#CommodityBatchTable').append(generateCommodityBatchTable(elt));
            });
        }
    );
}




function generateCommodityBatchTable(CommodityBatch) {
    return '<tr><td>' + CommodityBatch.rbId + '</td>' +
        '<td>' +'<input type="text" value="'+CommodityBatch.maengde +'">'+'</td>' +
        '<td>'+'<input type="text" value="' + CommodityBatch.raavareId + '">'+'</td>' +
        '<td onclick="updateCommodityBatch(' + CommodityBatch.rbId + ')">opdater raavarebatch</td>' +

        '<td onclick="deleteCommodityBatch(' + CommodityBatch.rbId + ')"><button>slet raavarebatch</button></td></tr> '


}