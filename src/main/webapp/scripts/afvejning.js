function sendID(){
    var getChoosenValue = document.getElementById("Products");
    var result = getChoosenValue.options[getChoosenValue.selectedIndex].value;
    $.ajax({
        url: '../rest/afvejning/' + result,
        method: 'get',
        contentType: "application/json", // det vi sender er json
        success: function (data) {
            alert(data)
        }
    });
}