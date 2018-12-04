package com.firststage.services.rest;

import com.firststage.services.entidades.Usuario;
import com.firststage.services.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepositorio.obtenerUsuarios();
    }

    @GetMapping("/{usuario}")
    public Usuario consultarPorUsuario(@PathVariable(value = "usuario") String usuario) {
        return usuarioRepositorio.buscarUsuario(usuario);
    }

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }


}
