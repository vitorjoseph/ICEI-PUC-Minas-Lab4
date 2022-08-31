package entities;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	//#region ATRIBUTOS

	private String username;
	private String email;
	private String senha;
	private TipoUsuario tipo;

	//#endregion

	//#region CONSTRUCTOR
	public Usuario(String username, String senha, TipoUsuario tipo) {
		this.username = username;
		this.senha = senha;
		this.tipo = tipo;
	}
	//#endregion

	//#region GETTERS e SETTERS

	public String getNome() {
		return username;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	//#endregion

	//#region METODOS ESPECIFICOS
	public boolean login(String username, String senha) {
		return this.username.equals(username) && this.senha.equals(senha);
	}
	//#endregion




}
