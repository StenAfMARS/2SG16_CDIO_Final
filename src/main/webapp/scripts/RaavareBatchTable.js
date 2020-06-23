function deleteRaavareBatch(id) {
    $.ajax({
        url: '../rest/raavareBatches/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#raavareBatchTable #tr' + data).remove();
        }
    });
}

function createRaavareBatch(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/raavareBatches',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadRaavareBatches();
        }
    });
}

function loadRaavareBatches() {
    $.get('../rest/raavareBatches',
        {},
        function (data, textStatus, req) {
            $("#raavareBatchTable").empty();
            $.each(data, function (i, elt) {
                $('#raavareBatchTable').append(addRaavareBatchOnTable(elt));
            });
        }
    );
}

function addRaavareBatchOnTable(raavareBatch) {
    return `<tr id="tr${raavareBatch.rbID}"><form id=\"${raavareBatch.rbID}\"></form>
        <td><input form=\"${raavareBatch.rbID}\" type=\"text\" name=\"raavareBatchID\" value=\"${raavareBatch.rbID}\" readonly=\"readonly\"></td>
        <td><input form=\"${raavareBatch.rbID}\" type=\"text\" name=\"raavareBatchName\" value=\"${raavareBatch.raavareID}\"></td>
        <td><input form=\"${raavareBatch.rbID}\" type=\"text\" name=\"ini\" value=\"${raavareBatch.maengde}\"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateRaavareBatch($(\'#raavareBatchTable #${raavareBatch.rbID}\'));\"></td>
        <td><input type=\"button\" onclick=\"deleteRaavareBatch(${raavareBatch.rbID});\" value=\"slet\"></td></tr>`;
}

function updateRaavareBatch(form){
    var settings = {
        "url": "../rest/raavareBatches",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadRaavareBatches();
    });
}
