function deleteProductBatch(id) {
    $.ajax({
        url: '../rest/productBatches/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#productBatchTable #tr' + data).remove();
        }
    });
}

function createProductBatch(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/productBatches',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadProductBatches();
        }
    });
}

function loadProductBatches() {
    $.get('../rest/productBatches',
        {},
        function (data, textStatus, req) {
            $("#productBatchTable").empty();
            $.each(data, function (i, elt) {
                $('#productBatchTable').append(addProductBatchOnTable(elt));
            });
        }
    );
}

function addProductBatchOnTable(productBatch) {
    return `<tr id="tr${productBatch.pbID}"><form id=\"${productBatch.pbID}\"></form>
        <td><input form=\"${productBatch.pbID}\" type=\"text\" name=\"productBatchID\" value=\"${productBatch.pbID}\" readonly=\"readonly\"></td>
        <td><input form=\"${productBatch.pbID}\" type=\"text\" name=\"productBatchName\" value=\"${productBatch.status}\"></td>
        <td><input form=\"${productBatch.pbID}\" type=\"text\" name=\"ini\" value=\"${productBatch.receptID}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatch($(\'#productBatchTable #${productBatch.pbID}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteProductBatch(${productBatch.pbID});\" value=\"slet\"></td></tr>`;
}

function updateProductBatch(form){
    var settings = {
        "url": "../rest/productBatches",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadProductBatches();
    });
}
