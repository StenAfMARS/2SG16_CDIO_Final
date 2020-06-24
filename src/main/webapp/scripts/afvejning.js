function sendID(){
    var getChoosenValue = document.getElementById("Products");
    document.pbID = getChoosenValue.options[getChoosenValue.selectedIndex].value;
    $.ajax({
        url: '../rest/afvejning/' + document.pbID,
        method: 'get',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            var receptComponent = data;
            $("#receptKomponentTable").empty();

            $('#receptKomponentTable').append(
                addReceptKomponentOnTable(receptComponent));
        }
    });
}
function loadReceptKomponents(ID) {
    $.get('../rest/ReceptComponents/'+ID,
        {},
        function (data, textStatus, req) {
            $("#receptKomponentTable").empty();
            $.each(data, function (i, elt) {
                $('#receptKomponentTable').append(addReceptKomponentOnTable(elt));
            });
        }
    );
}

function sendAfvejning(){
    var data = JSON.stringify({
        pbID:document.pbID,
        rbID:document.getElementsByName("rbID")[0].value,
        tara:document.getElementsByName("tara")[0].value,
        netto:document.getElementsByName("netto")[0].value
    });

    $.ajax({
        url: '../rest/afvejning/' + USERID,
        method: 'post',
        data: data,
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            alert(data);
        }
    });
}

function addReceptKomponentOnTable(receptKomponent) {
    let sel = receptKomponent.receptID + "_" + receptKomponent.raavareID;

    return `<tr id="tr${sel}"><form id=\"${sel}\"></form>
        <td><input form=\"${sel}\" type=\"number\" name=\"receptID\" value=\"${receptKomponent.receptID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"raavareID\" value=\"${receptKomponent.raavareID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"nonNetto\" value=\"${receptKomponent.nonNetto}\" step="0.001"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"tolerance\" value=\"${receptKomponent.tolerance}\" step="0.001"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponent($(\'#receptKomponentTable #${sel}\'));\"></td></tr>`;
}