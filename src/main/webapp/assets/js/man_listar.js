$(function listar() {

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/videojuego',
        success: function(videojuegos) {
            $.each(videojuegos, function (i, videojuego) {
              $('#videojuegos').append('<tr>\n' +
                                '    <td>\n' +
                                '        <span class="custom-checkbox">\n' +
                                '            <input type="checkbox" id="checkbox1" name="options[]" value="1">\n' +
                                '            <label for="checkbox1"></label>\n' +
                                '        </span>\n' +
                                '    </td>\n' +
                                '    <td>'+ (i + 1) +'</td>\n' +
                                '    <td>'+ videojuego.nombre +'</td>\n' +
                                '    <td>'+ videojuego.creador +'</td>\n' +
                                '    <td>'+ videojuego.fechaLanzamiento +'</td>\n' +
                                '    <td>\n' +
                                '        <input type="hidden" value=' + videojuego.codigo +'> '+
                                '        <a href="#editVideogameModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Editar">edit</i></a>\n' +
                                '        <a href="#deleteVideogameModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Eliminar">delete</i></a>\n' +
                                '    </td>  \n' +
                                '</tr>')
            });
            console.log('success', videojuegos);
        }
    });

});