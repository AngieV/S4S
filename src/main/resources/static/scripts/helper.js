
//create div and display new category
var HTMLproductEntry = '<div class="product-entry"></div>';
var HTMLproductCategory = '<div class="category-text">%data%</div>';
//display Item photo, name & Price
var HTMLproductPic = '<img src="%data%" class="productpic">';
//var HTMLproductPic = '<a href="#"><img src="%data%" class="productpic">';
var HTMLproductName = '%data%';
var HTMLproductPrice = ' - %data%</a>';
//display linked expanded Item details
var HTMLproductDescription = '<p><br>%data%</p>';

products.display = function() {

    products.product.forEach(function(product) {

        var formattedProduct = HTMLproductPic.replace("%data%", product.image);
        var formattedProductName= HTMLproductName.replace("%data%", product.name);
        var formattedProductDescription = HTMLproductPrice.replace("%data%", product.price);

        $("#products").append(HTMLproductEntry);
        $(".product-entry:last").append(HTMLproductCategory);
        $(".product-entry:last").append(formattedProduct);
        $(".product-entry:last").append(formattedProductName);
        $(".product-entry:last").append(formattedProductDescription);
    });
}

products.display();



