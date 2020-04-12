/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// thêm vào giỏ hàng ở trang index
$('#cart-id').click(function (e) {
    debugger
    e.preventDefault();
    var productId = $(this).data('id');
    $.ajax({
        url: 'http://localhost:8080/WebSite_BanGiay/cart',
        data: {productId: productId},
        dataType: 'json',
        type: 'POST',
        success: function (res) {
            if (res.status == true) {
                alert("ok");
                //$('.add-to-cart-success').show();
                var element = parseInt(document.querySelector('#cart-quantity').textContent);
                element = element + 1;
                document.querySelector('#cart-quantity').innerHTML = element;
            } else {
                alert("fail");
            }
        }
    });
});


// thêm giỏ hàng ở trang chi tiết

$('.btn-addtocar').click(function (e) {
    debugger
    e.preventDefault();
    var cartModel = {
        productId: $(this.data('id')),
        quantity: parseInt($('#quantity').val()) 
    }
    $.ajax({
        url: 'http://localhost:8080/WebSite_BanGiay/cart',
        data: {productId: JSON.stringify(cartModel)},
        dataType: 'json',
        type: 'POST',
        success: function (res) {
            if (res.status === true) {
                alert("ok");
                //$('.add-to-cart-success').show();
                var element = parseInt(document.querySelector('#cart-quantity').textContent);
                element = element + 1;
                document.querySelector('#cart-quantity').innerHTML = element;
            } else {
                alert("fail");
            }
        }
    });
});