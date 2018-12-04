$(function () {

    $("#agregar").click(function () {
        var videojuego = {
            nombre : $("#nombre").val(),
            fechaLanzamiento : $("#fechaLanzamiento").val(),
            creador : $("#creador").val(),
            genero : $("#genero").val(),
            plataforma : $("#plataforma").val(),
            calificacion : $("#calificacion").val(),
            rutaImagen : $("#ruta").val(),
        }

        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: 'http://localhost:8080/videojuego',
            data: JSON.stringify(videojuego),
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