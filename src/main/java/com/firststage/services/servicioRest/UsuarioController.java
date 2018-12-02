package com.firststage.services.servicioRest;

import com.firststage.services.entidades.Usuario;
import com.firststage.services.negocio.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private Negocio negocio;

    @GetMapping("/{usuario}")
    public Usuario consultar(@PathVariable(value = "usuario") String usuario) {
        return negocio.consultarUsuario(usuario);
    }

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return negocio.registrarUsuario(usuario);
    }
}
