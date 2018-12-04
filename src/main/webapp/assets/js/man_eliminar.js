$(function () {

    $("#eliminar").click(function () {

        var codigo = $(this).parent().find('input').val();
        var workingObject = $(this);

        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/videojuego/' + codigo,

            success: function () {

                workingObject.closest('tr').remove();

                console.log('Eliminado');
            },
            error: function (xhr, textStatus, errorThown) {
                console.log('Error en operación.');
            }
        });
    });
});