package entities;

public class Disciplina {

	private String nome;
	private int creditos;
	private boolean obrigatoria;

	public Disciplina(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
		this.obrigatoria = false;
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}
}
