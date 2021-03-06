function deleteProductBatchKomponent(id) {
    $.ajax({
        url: '../rest/productBatchKomponents/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#productBatchKomponentTable #tr' + data).remove();
        }
    });
}

function createProductBatchKomponent(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/productBatchKomponents',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadProductBatchKomponents();
        }
    });
}

function loadProductBatchKomponents() {
    $.get('../rest/productBatchKomponents',
        {},
        function (data, textStatus, req) {
            $("#productBatchKomponentTable").empty();
            $.each(data, function (i, elt) {
                $('#productBatchKomponentTable').append(addProductBatchKomponentOnTable(elt));
            });
        }
    );
}

function addProductBatchKomponentOnTable(productBatchKomponent) {
    let sel = productBatchKomponent.pbID + "_" + productBatchKomponent.rbID;

    return `<tr id="tr${sel}"><form id=\"${sel}\"></form>
        <td><input form=\"${sel}\" type=\"number\" name=\"pbID\" value=\"${productBatchKomponent.pbID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"rbID\" value=\"${productBatchKomponent.rbID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"tara\" value=\"${productBatchKomponent.tara}\" step="0.001"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"netto\" value=\"${productBatchKomponent.netto}\" step="0.001"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"oprID\" value=\"${productBatchKomponent.oprID}\" readonly=\"readonly\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatchKomponent($(\'#productBatchKomponentTable #${sel}\'));\"></td></tr>`;
}

function updateProductBatchKomponent(form){
    var settings = {
        "url": "../rest/productBatchKomponents",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadProductBatchKomponents();
    });
}
