$(document).ready(function () {
    loadProductComponents();
});

function deleteProductComponents(id) {
    $.post('rest/ProductComponents/deleteProductComponents', {"UserID":id}, data => alert(JSON.stringify(data)));
}

function loadProductComponents() {
    $.post('rest/ProductComponents/getProductComponentsList',
        {},
        function (data, textStatus, req) {
            $("#ProductComponentsTable").empty();
            $.each(data, function (i, elt) {
                $('#ProductComponentsTable').append(generateProductComponentsTable(elt));
            });
        }
    );
}


function generateProductComponentsTable(ProductComponents) {
    return '<tr><td>' + ProductComponents.UserID + '</td>' +
        '<td>' +'<input type="text" value="'+ProductComponents.rbId +'">'+'</td>' +
        '<td>'+'<input type="text" value="' + ProductComponents.tara + '">'+'</td>' +
        '<td>'+'<input type="text" value="' + ProductComponents.netto + '">'+'</td>' +
        '<td>'+'<input type="text" value="' + ProductComponents.pbId + '">'+'</td>' +
        '<td onclick="updateProductComponents(' + ProductComponents.UserID + ')">opdater ProduktComponents</td>' +
        '<td onclick="deleteProductComponents(' + ProductComponents.UserID + ')"><button>slet ProduktComponents</button></td></tr> '

}
// function updateProductComponentsByID(id){
//     switchPage("Views/ProductComponentsForm.html");
//     document.uuuuserID = userID;
// }

function updateProductComponents(UserID,RaavareBatchId,Tara,Netto,ProduktbatchId){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO_Final_war_exploded/rest/productComponents/updateProductComponents",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"userID":UserID,"RaavareBatchId":RaavareBatchId,"Tara":Tara,"Netto":Netto,"ProduktbatchId":ProduktbatchId}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
