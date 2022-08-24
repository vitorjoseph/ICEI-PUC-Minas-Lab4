package entities;

import java.util.Date;

public abstract class Usuario {

	private int codigo_usuario;

	private String nome;

	private Date data_nascimento;

	private String endereco;

	public Usuario(String nome, Date data_nascimento, String endereco) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
	}

}
