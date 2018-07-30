'use strict';

$("#adelante").on("click", function () {

    let direccion = document.getElementById('adelante');


    $(document).ready(function () {

        $.ajax({

            url: direccion.dataset.ruta, success: function (data) {
                $('.jscroll-inner').html(data);
            }
        });
    });
});

$("#atras").on("click", function () {

    let direccion = document.getElementById('atras');


    $(document).ready(function () {

        $.ajax({
            url: direccion.dataset.ruta, success: function (data) {
                $('.jscroll-inner').html(data);
            }
        });
    });
});

