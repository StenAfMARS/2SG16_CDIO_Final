function deleteReceptKomponent(id) {
    $.ajax({
        url: '../rest/ReceptComponents/' + id,
        method: 'delete',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            $('#receptKomponentTable #tr' + data).remove();
        }
    });
}

function createReceptKomponent(form) {
    var data = form.serializeJSON();
    $.ajax({
        url: '../rest/ReceptComponents',
        method: 'POST',
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function(data){
            loadReceptKomponents();
        }
    });
}

function loadReceptKomponents() {
    $.get('../rest/ReceptComponents',
        {},
        function (data, textStatus, req) {
            $("#receptKomponentTable").empty();
            $.each(data, function (i, elt) {
                $('#receptKomponentTable').append(addReceptKomponentOnTable(elt));
            });
        }
    );
}

function addReceptKomponentOnTable(receptKomponent) {
    let sel = receptKomponent.receptID + "," + receptKomponent.raavareID;

    return `<tr id="tr${sel}"><form id=\"${sel}\"></form>
        <td><input form=\"${sel}\" type=\"number\" name=\"receptID\" value=\"${receptKomponent.receptID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"raavareID\" value=\"${receptKomponent.raavareID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"nonNetto\" value=\"${receptKomponent.nonNetto}\" step="0.001"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"tolerance\" value=\"${receptKomponent.tolerance}\" step="0.001"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponent($(\'#receptKomponentTable #${sel}\'));\"></td></tr>`;
}

function updateReceptKomponent(form){
    var settings = {
        "url": "../rest/ReceptComponents",
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": form.serializeJSON()
    };

    $.ajax(settings).done(function (response) {
        loadReceptKomponents();
    });
}
