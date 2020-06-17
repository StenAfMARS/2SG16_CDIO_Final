$(document).ready(function () {
    loadProduct();
});

function deleteProduct(id) {
    $.post('rest/Product/deleteProduct', {"pbId":id}, data => alert(JSON.stringify(data)));
}

function loadProduct() {
    $.post('rest/Product/getProductList',
        {},
        function (data, textStatus, req) {
            $("#productTable").empty();
            $.each(data, function (i, elt) {
                $('#productTable').append(generateProductTable(elt));
            });
        }
    );
}



function generateProductTable(Product) {
    return '<tr><td>' + Product.pbId + '</td>' +
        '<td>' +'<input type="text" value="'+Product.Status +'">'+'</td>' +
        '<td>'+'<input type="text" value="' + Product.receptId + '">'+'</td>' +
        '<td onclick="updateProduct(' + Product.pbId + ')">opdater Produkt</td>' +
        '<td onclick="deleteProduct(' + Product.pbId + ')"><button>slet Produkt</button></td></tr> '



}







