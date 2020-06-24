function sendID(){
    var getChoosenValue = document.getElementById("Products");
    var result = getChoosenValue.options[getChoosenValue.selectedIndex].value;
    $.ajax({
        url: '../rest/afvejning/' + result,
        method: 'get',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            alert(data)
            loadReceptKomponents(data)
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

function addReceptKomponentOnTable(receptKomponent) {
    let sel = receptKomponent.receptID + "_" + receptKomponent.raavareID;

    return `<tr id="tr${sel}"><form id=\"${sel}\"></form>
        <td><input form=\"${sel}\" type=\"number\" name=\"receptID\" value=\"${receptKomponent.receptID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"raavareID\" value=\"${receptKomponent.raavareID}\" readonly=\"readonly\"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"nonNetto\" value=\"${receptKomponent.nonNetto}\" step="0.001"></td>
        <td><input form=\"${sel}\" type=\"number\" name=\"tolerance\" value=\"${receptKomponent.tolerance}\" step="0.001"></td>
        <td><input type=\"button\" value=\"opdater\" onclick=\"updateReceptKomponent($(\'#receptKomponentTable #${sel}\'));\"></td></tr>`;
}