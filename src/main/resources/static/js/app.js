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

    $('#transfer-submit').on('click', function(event){
        if($('#list-wallets-from').val() == $('#list-wallets-to').val()) {
            event.preventDefault();
            $('.error-id-wallet').text('Wallet cannot be the same');
            $('#list-wallets-from').css('border-color', 'red');
            $('#list-wallets-to').css('border-color', 'red');
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
           $('#list-wallets-from').css('border-color', 'red');
           $('#list-wallets-to').css('border-color', 'red');
        }

        if($('#list-wallets-from').val() != $('#list-wallets-to').val()) {
            $('.error-id-wallet').text('');
            $('#list-wallets-from').css('border-color', '#ced4da');
            $('#list-wallets-to').css('border-color', '#ced4da');
        }
    });


})(jQuery); // End of use strict
