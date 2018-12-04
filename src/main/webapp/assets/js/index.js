$(function () {

    var usuario = $('#usuario').val();
    var password = $('#password').val();

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/usuario',
        success: function(usuarios) {
            $.each(usuarios, function (i, u) {
                if (usuario == u.usuario && password == u.password) {

                    if (u.usuario == 'admin') {
                        window.location.href='mantenimiento/mantenimiento.html';
                    }

                    window.location.href="lista.html";
                }
            });

            console.log('success', usuarios);
        }
    });

});