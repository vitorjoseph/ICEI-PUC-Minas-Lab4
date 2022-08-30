package entities;

public class Disciplina {

	//#region ATRIBUTOS
	private String nome;
	private int creditos;
	private boolean obrigatoria;
	private int preco;
	//#endregion

	//#region CONSTRUCTOR
	public Disciplina(String nome, int creditos, int preco) {
		this.nome = nome;
		this.creditos = creditos;
		this.obrigatoria = false;
		this.preco = preco;
	}
	//#endregion

	//#region GETTERS e SETTERS
	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public int getPreco() {
		return preco;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}
	//#endregion

	//#region METODOS ESPECIFICOS

	//#endregion
}
