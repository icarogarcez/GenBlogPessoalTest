package org.generation_blogpessoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioLogin {

	private String nome;
	private String usuario;
	private String senha;
	private String token;

}
