$(document).ready(function () {
    loadCommodity();
});

function deleteCommodity(id) {
    $.ajax({
        url: '../rest/raavarer/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#userTable #tr' + data).remove();
        }
    });
}
function createCommodity(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/raavarer',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadCommodity();
        }
    });
}
function loadCommodity() {
    $.post('rest/raavarer',
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
    return `<tr id="tr${Commodity.raavareId}"><form id=\"${Commodity.raavareId}\"></form>
        <td><input form=\"${Commodity.raavareId}\" type=\"text\" name=\"userID\" value=\"${Commodity.raavareId}\" readonly=\"readonly\"></td>
        <td><input form=\"${Commodity.raavareId}\" type=\"text\" name=\"userName\" value=\"${Commodity.raavareName}\"></td>
        <td><input form=\"${Commodity.raavareId}\" type=\"text\" name=\"ini\" value=\"${Commodity.raavareLeverandoer}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateCommodity($(\'#commodityBatchTable #${Commodity.raavareId}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteCommodity(${Commodity.raavareId});\" value=\"slet\"></td></tr>`;



}

function updateCommodity(form){
    var settings = {
        "url": "../rest/raavarer",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadCommodity();
    });
}
