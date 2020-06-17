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