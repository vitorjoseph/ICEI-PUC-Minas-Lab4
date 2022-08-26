package entities;

public class Disciplina {

	//#region ATRIBUTOS
	private String nome;
	private int creditos;
	private boolean obrigatoria;
	//#endregion

	//#region CONSTRUCTOR
	public Disciplina(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
		this.obrigatoria = false;
	}
	//#endregion

	//#region GETTERS e SETTERS
	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}
	//#endregion

	//#region METODOS ESPECIFICOS
	//#endregion
}
