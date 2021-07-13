package org.generation_blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.generation_blogpessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() throws ParseException {

		LocalDate data = LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		Usuario usuario = new Usuario(0, "Chidi Anagonye", "nerdolafilosofo@gmail.com", "theanswer", data);
		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0, "Tahani Al-Jamil", "tallbritish@gmail.com", "hotstuff", data);
		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0, "Jason Mendoza", "djmusic@gmail.com", "mygirl", data);
		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0, "Eleanor Shellstrop Anagonye", "thebestperson@gmail.com", "shrimps", data);
		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
	}

	@Test
	@DisplayName("💾 Retorna o nome")
	public void findByNomeRetornaNome() throws Exception {

		Usuario usuario = usuarioRepository.findByNome("Chidi");
		assertTrue(usuario.getNome().equals("Chidi"));
	}
	
	@Disabled
	@Test
	@DisplayName("💾 Retorna 3 usuarios")
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Anagonye");
		assertEquals(2, listaDeUsuarios.size());
	}
	
	@Disabled
	@AfterAll
	public void end() {

		usuarioRepository.deleteAll();

	}
}