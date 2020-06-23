function loadReceptKomponents() {
    $.get('../rest/ReceptComponents',
        {},
        function (data, textStatus, req) {
            $("#ReceptComponentsTable").empty();
            $.each(data, function (i, elt) {
                $('#ReceptComponentsTable').append(addReceptKomponentOnTable(elt));
            });
        }
    );
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

function updateReceptKomponents(form){
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

function addReceptKomponentOnTable(ReceptComponents) {
    return `<tr id="tr${ReceptComponents.raavareID}"><form id=\"${ReceptComponents.raavareID}\"></form>
        <td><input form=\"${ReceptComponents.raavareID}\" type=\"number\" name=\"raavareID\" value=\"${ReceptComponents.raavareID}\" readonly=\"readonly\"></td>
        <td><input form=\"${ReceptComponents.raavareID}\" type=\"number\" name=\"ReceptID\" value=\"${ReceptComponents.RecepID}\" readonly=\"readonly\"></td>
        <td><input form=\"${ReceptComponents.raavareID}\" type=\"number\" name=\"nonNetto\" value=\"${ReceptComponents.nonNetto}\" step="0.001"></td>
        <td><input form=\"${ReceptComponents.raavareID}\" type=\"number\" name=\"tolerance\" value=\"${ReceptComponents.tolerance}\" step="0.001"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponents($(\'#ReceptComponentsTable #${ReceptComponents.raavareID}\'));\"></td></tr>`;
}