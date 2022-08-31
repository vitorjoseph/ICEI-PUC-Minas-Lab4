package entities;

import java.io.Serializable;
import java.util.Date;

public abstract class Usuario implements Serializable {

	//#region ATRIBUTOS

	private String nome;
	private String senha;
	private Date data_nascimento;
	private String endereco;

	//#endregion

	//#region CONSTRUCTOR
	public Usuario(String nome, Date data_nascimento, String endereco) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
	}
	//#endregion

	//#region GETTERS e SETTERS
	//#endregion

	//#region METODOS ESPECIFICOS
	public boolean login(String codigo_usuario, String senha) {
		throw new Error("Not implemented!");
	}
	//#endregion

	public String getNomeDeUsuario() {
		return nome;
	}

	public void setNomeDeUsuario(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}




}
