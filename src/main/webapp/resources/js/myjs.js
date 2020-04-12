/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/* Assign actions */
//    $('.input-number').change(function () {
//        updateQuantity(this);
//    });

$('.product-removal button').click(function () {
    removeItem(this);
});

/* Recalculate cart */
function recalculateCart() {
    var subtotal = 0;

    /* Sum up row totals */
    $('.totals').each(function () {
        subtotal += parseFloat($(this).text());
    });
    $('.sub-totals').html(subtotal);
    $('.cart-totals').html(subtotal);
    debugger

}

/* Update quantity */
function updateQuantity(quantityInput) {
    /* Calculate line price */
    var productRow = $(quantityInput).parent().parent().parent();
    var price = parseFloat(productRow.children().children().children().children('.price').text());
    var quantity = $(quantityInput).val();
    var linePrice = price * quantity;
    var cartModel = {
        productId: $(this).data('id'),
        quantity: quantity
    }
    debugger
    $.ajax({
        url: '/WebSite_BanGiay/cart/updateCartItem',
        type: 'POST',
        data: {cartModel: JSON.stringify(cartModel)},
        dataType: 'json',
        success: function (res) {
            debugger
            if (res.status == true) {
                productRow.children().children().children().children('.totals').each(function () {
                    $(this).html(linePrice.toFixed(2));
                    recalculateCart();
                });
            } else {
                alert("Đã có lỗi xảy ra, không thể update lại giỏ hàng !!!");
                window.location.href = "/WebSite_BanGiay/cart";
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            debugger
            // When AJAX call has failed
            console.log('AJAX call failed.');
            console.log(textStatus + ': ' + errorThrown);
        },

    });

    /* Update line price display and recalc cart totals */

}


/* Remove item from cart */
function removeItem(removeButton) {
    /* Remove row from DOM and recalc cart total */
    var productRow = $(removeButton).parent().parent();
    productRow.slideUp(fadeTime, function () {
        productRow.remove();
        recalculateCart();
    });
}


$('.btn-number').click(function (e) {
    e.preventDefault();
    var fieldName = $(this).attr('data-field');
    var type = $(this).attr('data-type');
    var input = $("input[name='" + fieldName + "']");
    var currentVal = parseInt(input.val());
    var productId = input.data('id');
    if (!isNaN(currentVal)) {
        if (type == 'minus') {
            var minValue = parseInt(input.attr('min'));
            if (!minValue)
                minValue = 1;
            if (currentVal > minValue) {
                input.val(currentVal - 1).change();
                updateQuantity(input);
            }
            if (parseInt(input.val()) == minValue) {
                $(this).attr('disabled', true);
            }
        } else if (type == 'plus') {
            var maxValue = parseInt(input.attr('max'));
            if (!maxValue)
                maxValue = 100;
            if (currentVal < maxValue) {
                input.val(currentVal + 1).change();
                updateQuantity(input);

            }
            if (parseInt(input.val()) == maxValue) {
                $(this).attr('disabled', true);
            }
        }
    } else {
        input.val(0);
    }
});


function ajaxAddItemToCart(cartModel) {
    $.ajax({
        url: '/WebSite_BanGiay/cart/addItemByAjax',
        data: {cartModel: cartModel},
        dataType: 'json',
        type: 'POST',
        success: function (res) {
            if (res.status === true) {
                console.log(res);
                alert("ok");
                //$('.add-to-cart-success').show();
                debugger
                var element = parseInt(document.querySelector('#cart-quantity').textContent);
                element = element + res.quantity;
                document.querySelector('#cart-quantity').innerHTML = element;
            } else {
                alert("fail");
            }
        }
    });
}


// thêm vào giỏ hàng ở trang index
$('.cart-hover').click(function (e) {
    debugger
    e.preventDefault();
    var cartModel = {
        productId: $(this).data('id'),
        quantity: 1
    }
    ajaxAddItemToCart(JSON.stringify(cartModel));
});



// thêm giỏ hàng ở trang chi tiết

//$('#cart-id').click(function (e) {
//    debugger
//    e.preventDefault();
//    var cartModel = {
//        productId: $(this).data('id'),
//        quantity: parseInt($('#quantity').val()) 
//    }
//   
//    ajaxAddItemToCart(JSON.stringify(cartModel));
//    
//});
