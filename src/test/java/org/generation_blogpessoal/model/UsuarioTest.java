package org.generation_blogpessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
    
    public Usuario usuario;
    public Usuario usuarioErro = new Usuario();

	@Autowired
	private  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();

	@BeforeEach
	public void start() {

		LocalDate data = LocalDate.parse("1989-12-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		usuario = new Usuario(0L, "Taylor Swift", "loirinhacaipira@gmail.com", "folkmore13", data);

	}

	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		
		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}

	@Test
	@DisplayName("❌ Valida Atributos Nulos")
	void testValidaAtributosNulos() {
		
		usuarioErro.setUsuario("loirinhacaipira@gmail.com");

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		
		System.out.println(violacao.toString());

		assertFalse(violacao.isEmpty());
		
	}
}