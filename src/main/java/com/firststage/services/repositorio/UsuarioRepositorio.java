package com.firststage.services.repositorio;

import com.firststage.services.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    @Query("select u from Usuario u")
    List<Usuario> obtenerUsuarios();

    @Query("select u from Usuario u where u.usuario =:usuario")
    Usuario buscarUsuario(@Param("usuario") String usuario);
}
