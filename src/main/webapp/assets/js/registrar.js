$(function () {

    $("#btnRegistrar").click(function () {
        var persona = {
            nombres : $("#nombres").val(),
            apellidos : $("#apellidos").val(),
            pais : $("#pais").val(),
            email : $("#email").val(),
            usuario : $("#usuario").val(),
            password : $("#password").val(),
            generoVideojuego : $("#genero").val(),
            medioComunicacion : $("#medio").val()
        }

        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: 'http://localhost:8080/usuario/registrar',
            data: JSON.stringify(persona),
            dataType: 'json',
            success: function (data, textStatus, xhr) {
                console.log(data);
            },
            error: function (xhr, textStatus, errorThown) {
                console.log('Error en operación.');
            }
        });
    });
});