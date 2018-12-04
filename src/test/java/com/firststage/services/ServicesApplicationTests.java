package com.firststage.services;

import com.firststage.services.entidades.Usuario;
import com.firststage.services.entidades.Videojuego;
import com.firststage.services.repositorio.UsuarioRepositorio;
import com.firststage.services.repositorio.VideojuegoRepositorio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@SpringBootTest
public class ServicesApplicationTests {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private VideojuegoRepositorio videojuegoRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRegistrarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombres("Abel");
		usuario.setApellidos("Perez Luna");
		usuario.setPais("Peru");
		usuario.setEmail("abel@gmail.com");
		usuario.setUsuario("abel20");
		usuario.setPassword("12345678");
		usuario.setGeneroVideojuego("Pelea");
		usuario.setMedioComunicacion("Foros");
		Usuario u = usuarioRepositorio.save(usuario);
		Assert.assertNotNull(u);
	}

	@Test
	public void testConsultarUsuario() {
		Usuario usuario = usuarioRepositorio.buscarUsuario("abel20");
		Assert.assertNotNull(usuario);
	}

	@Test
	public void testRegistrarVideojuego() {
		Videojuego videojuego = new Videojuego();
		videojuego.setNombre("SUPERMARIO BROS 2");
		videojuego.setCreador("Nintendo");
		videojuego.setFechaLanzamiento(new Date());
		videojuego.setGenero("Role-playing");
		videojuego.setPlataforma("Supernintendo");
		videojuego.setCalificacion("8");
		Videojuego v = videojuegoRepositorio.save(videojuego);
		Assert.assertNotNull(v);

	}

	@Test
	public void testActualizarVideojuego() {
		Optional<Videojuego> optional = videojuegoRepositorio.findById(7L);
		Videojuego videojuego = optional.get();
		videojuego.setNombre("STUDIO MDHR");
		videojuegoRepositorio.save(videojuego);

		Assert.assertEquals("STUDIO MDHR", videojuego.getNombre());
	}


	@Test
	public void testListarNuevosVideojuegos() {
		List<Videojuego> videojuegos = videojuegoRepositorio.listarNuevos();
		for (Videojuego v: videojuegos) {
			System.out.println(v.getNombre() + " " + v.getCreador() + " " + v.getFechaLanzamiento());
		}

		Assert.assertNotNull(videojuegos);
	}

	@Test
	public void testListarMejoresVideojuegos() {
		List<Videojuego> videojuegos = videojuegoRepositorio.listarCalificacion();
		for (Videojuego v: videojuegos) {
			System.out.println(v.getNombre() + " " + v.getCreador() + " " + v.getFechaLanzamiento());
		}

		Assert.assertNotNull(videojuegos);
	}
}
