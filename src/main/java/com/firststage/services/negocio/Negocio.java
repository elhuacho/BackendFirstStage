package com.firststage.services.negocio;

import com.firststage.services.entidades.Usuario;
import com.firststage.services.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Negocio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario consultarUsuario(String usuario) {
        return usuarioRepositorio.buscarUsuario(usuario);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

}
