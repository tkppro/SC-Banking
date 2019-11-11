(function($) {
    "use strict"; // Start of use strict

    // Floating label headings for the contact form
    $("body").on("input propertychange", ".floating-label-form-group", function(e) {
        $(this).toggleClass("floating-label-form-group-with-value", !!$(e.target).val());
    }).on("focus", ".floating-label-form-group", function() {
        $(this).addClass("floating-label-form-group-with-focus");
    }).on("blur", ".floating-label-form-group", function() {
        $(this).removeClass("floating-label-form-group-with-focus");
    });

    // Show the navbar when the page is scrolled up
    var MQL = 992;

    //primary navigation slide-in effect
    if ($(window).width() > MQL) {
        var headerHeight = $('#mainNav').height();
        $(window).on('scroll', {
                previousTop: 0
            },
            function() {
                var currentTop = $(window).scrollTop();
                //check if user is scrolling up
                if (currentTop < this.previousTop) {
                    //if scrolling up...
                    if (currentTop > 0 && $('#mainNav').hasClass('is-fixed')) {
                        $('#mainNav').addClass('is-visible');
                    } else {
                        $('#mainNav').removeClass('is-visible is-fixed');
                    }
                } else if (currentTop > this.previousTop) {
                    //if scrolling down...
                    $('#mainNav').removeClass('is-visible');
                    if (currentTop > headerHeight && !$('#mainNav').hasClass('is-fixed')) $('#mainNav').addClass('is-fixed');
                }
                this.previousTop = currentTop;
            });
    }

    //Validation for transfer
    $('#transfer-submit').on('click', function(event){
        if($('#list-wallets-from').val() == $('#list-wallets-to').val()) {
            event.preventDefault();
            $('.error-id-wallet').text('Wallet cannot be the same');
            $('#list-wallets-from, #list-wallets-to').css('border-color', 'red');
        }

        if($('#amount-transfer-input').val().length == 0 || $('#amount-transfer-input').val() == 0) {
            event.preventDefault();
            $('#error-amount-transfer-input').text('Need a number bigger than 0!');
            $('#amount-transfer-input').css('border-color', 'red');

        } else
            $('#transfer-submit').submit();
    });

    $('#amount-transfer-input').keyup(function() {
        if($('#amount-transfer-input').val().length >= 0) {
            $('#error-amount-transfer-input').text('');
            $('#amount-transfer-input').css('border-color', '#ced4da');
        }

        if($('#amount-transfer-input').val().length == 0 || $('#amount-transfer-input').val() == 0) {
            $('#error-amount-transfer-input').text('Need a number bigger than 0!');
            $('#amount-transfer-input').css('border-color', 'red');
        }
    });

    $('#list-wallets-from, #list-wallets-to').change(function () {
        if($('#list-wallets-from').val() == $('#list-wallets-to').val()) {
           $('.error-id-wallet').text('Wallet cannot be the same');
           $('#list-wallets-from, #list-wallets-to').css('border-color', 'red');
        }

        if($('#list-wallets-from').val() != $('#list-wallets-to').val()) {
            $('.error-id-wallet').text('');
            $('#list-wallets-from, #list-wallets-to').css('border-color', '#ced4da');
        }
    });
    //Call Ajax for payment
    $('.bill-name').click(function (event) {
        event.preventDefault();
        $('#payment-name-header').text($(this).text() + " Payment")
        $('#bill-id-data').val(this.id);

    })

    validatePaymentForm();

    $('.alert').css('display', 'none');
    getPaymentMethod();
})(jQuery); // End of use strict

function ajaxPayment() {

    var billId = $('#bill-id-data').val();
    var consumberNumber = $('#consumer-no').val();
    var billNumber = $('#bill-no').val();
    var walletId = $('#list-wallets').val();
    var cardId = $('#list-cards').val();
    var amount = $('#payment-amount').val();
    var userId = "1";

    var datas = {};
    datas['consumerNumber'] = consumberNumber;
    datas['billNumber'] = billNumber;
    datas['amount'] = amount;

    datas['user_id'] = userId;
    datas['bill_id'] = billId;
    if($('#card-payment').is(':checked'))
        datas['card_id'] = cardId;
    if($('#wallet-payment').is(':checked'))
        datas['wallet_id'] = walletId;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/payments",
        data: JSON.stringify(datas),
        dataType: 'json',
        success: function (data) {
            $('.alert').addClass('alert-success').removeClass('alert-danger').text(data['msg']).fadeIn(1000);
            $('.alert').css('display', 'block');

        },
        error: function (e) {
            $('.alert').addClass('alert-danger').removeClass('alert-success').text(e.responseJSON.msg).fadeIn(1000);
            $('.alert').css('display', 'block');
        }
    });
}

function validatePaymentForm()
{
    $('#payment-submit').on('click', function (event) {
        event.preventDefault();
        if($('#consumer-no').val().length == 0)
        {
            setError('#consumer-no');
        }
        if($('#bill-no').val().length == 0)
        {
            setError('#bill-no');
        }
        if($('#payment-amount').val().length == 0)
        {
            setError("#payment-amount");
        }
        else
        {
            removeError();
            ajaxPayment();
        }

    });

    $('.error-empty-input')
}

function setError(fieldId)
{
    $(fieldId).css('border-color', 'red');
    $(fieldId + '-error').text('This field cannot be blank');
}

function removeError() {
    $('#consumer-no, #bill-no, #payment-amount ').css('border-color', '#ced4da');
    $('.error-empty-input').each(function (i) {
        $(this).text('');
    });

}

function getPaymentMethod()
{
    $('.form-check-input').on('click', function () {
        if($('#wallet-payment').is(':checked')){
            $('#card-select-option').css('display', 'none');
            $('#wallet-select-option').css('display', 'flex');
        }
        if($('#card-payment').is(':checked')){
            $('#wallet-select-option').css('display', 'none');
            $('#card-select-option').css('display', 'flex');
        }
    });

}
