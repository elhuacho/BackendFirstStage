package com.firststage.services.repositorio;

import com.firststage.services.entidades.Videojuego;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideojuegoRepositorio extends CrudRepository<Videojuego, Long> {
    @Query("select v from Videojuego v order by v.fechaLanzamiento desc")
    List<Videojuego> listarNuevos();

    @Query("select v from Videojuego v order by v.calificacion desc")
    List<Videojuego> listarCalificacion();
}
