package entities;

import java.util.Date;

public class Usuario {

	//#region ATRIBUTOS

	private String nome;
	private int senha;
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




}
