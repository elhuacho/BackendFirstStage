$(function () {

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/videojuego/mejores',
        success: function(videojuegos) {
            $.each(videojuegos, function (i, videojuego) {
                $('#videojuegos').append('<li><a href="#"><div class="box_img"><img src='+ videojuego.rutaImagen +'>\n' +
                    '\t</div>' +
                    '<div class="box_title">\n' +
                    '\t\t<div >\n' +
                    '\t\t\t\t\t<h4>' + videojuego.nombre + '</h4>\n' +
                    '\t\t\t\t\t<p> <b>Fecha de Lanzamiento:</b> ' + videojuego.fechaLanzamiento + '</p>\n' +
                    '\t\t\t\t\t<p> <b>Creador:</b> ' + videojuego.creador + '</p>\n' +
                    '\t\t\t\t\t<p> <b>Género:</b> ' + videojuego.genero + '</p>\n' +
                    '\t\t\t\t\t<p> <b>Plataforma:</b> ' + videojuego.plataforma + '</p>\n' +
                    '\t\t\t\t\t<p> <b>Calificación:</b> ' + videojuego.calificacion + '</p>\n' +
                    '\t\t</div>\n' +
                    '</div>\n' +
                    '</a></li>')
            });
            console.log('success', videojuegos);
        }
    });

});