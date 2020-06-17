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


function updateProduct(ProductId,Status,ReceptId){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO_Final_war_exploded/rest/product/updateProduct",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"ProductId":ProductId,"Status":Status,"ReceptId":ReceptId}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}




