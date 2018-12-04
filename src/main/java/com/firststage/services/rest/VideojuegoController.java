package com.firststage.services.rest;

import org.springframework.util.Assert;
import com.firststage.services.entidades.Videojuego;
import com.firststage.services.repositorio.VideojuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videojuego")
public class VideojuegoController {

    @Autowired
    private VideojuegoRepositorio videojuegoRepositorio;

    public VideojuegoController(VideojuegoRepositorio videojuegoRepositorio) {
        this.videojuegoRepositorio = videojuegoRepositorio;
    }

    @GetMapping
    public List<Videojuego> listar() {
        return videojuegoRepositorio.listar();
    }

    @PostMapping
    public void registrarVideojuego(@RequestBody Videojuego videojuego) {
        videojuegoRepositorio.save(videojuego);
    }

    @PutMapping("/{codigo}")
    public void actualizarVideojuego(@PathVariable long codigo, @RequestBody Videojuego videojuego) {
        Videojuego videojuegoExistente = videojuegoRepositorio.findById(codigo).get();
        Assert.notNull(videojuegoExistente, "Videojuego no encontrado");
        videojuegoExistente.setNombre(videojuego.getNombre());
        videojuegoExistente.setCreador(videojuego.getCreador());
        videojuegoExistente.setFechaLanzamiento(videojuego.getFechaLanzamiento());
        videojuegoExistente.setGenero(videojuego.getGenero());
        videojuegoExistente.setPlataforma(videojuego.getPlataforma());
        videojuegoExistente.setCalificacion(videojuego.getCalificacion());
        videojuegoRepositorio.save(videojuegoExistente);
    }

    @DeleteMapping("/{codigo}")
    public void eliminarVideojuego(@PathVariable long codigo) {
        videojuegoRepositorio.deleteById(codigo);
    }

    @GetMapping("/nuevos")
    public List<Videojuego> listarNuevosVideojuegos() {
        return videojuegoRepositorio.listarNuevos();
    }

    @GetMapping("/mejores")
    public List<Videojuego> listarMejoresVideojuegos() {
        return videojuegoRepositorio.listarCalificacion();
    }



}
