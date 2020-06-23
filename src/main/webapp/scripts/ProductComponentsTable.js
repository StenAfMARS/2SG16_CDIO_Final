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
    return `<tr id="tr${productBatchKomponent.pbID}"><form id=\"${productBatchKomponent.pbID}\"></form>
        <td><input form=\"${productBatchKomponent.pbID}\" type=\"text\" name=\"pbID\" value=\"${productBatchKomponent.pbID}\" readonly=\"readonly\"></td>
        <td><input form=\"${productBatchKomponent.pbID}\" type=\"text\" name=\"rbID\" value=\"${productBatchKomponent.rbID}\"></td>
        <td><input form=\"${productBatchKomponent.pbID}\" type=\"text\" name=\"tara\" value=\"${productBatchKomponent.tara}\"></td>
        <td><input form=\\"${productBatchKomponent.pbID}\\" type=\\"text\\" name=\\"netto\\" value=\\"${productBatchKomponent.netto}\\"></td>
        <td><input form=\\"${productBatchKomponent.pbID}\\" type=\\"text\\" name=\\"oprID\\" value=\\"${productBatchKomponent.oprID}\\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateProductBatchKomponent($(\'#productBatchKomponentTable #${productBatchKomponent.pbID}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteProductBatchKomponent(${productBatchKomponent.pbID});\" value=\"slet\"></td></tr>`;
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
