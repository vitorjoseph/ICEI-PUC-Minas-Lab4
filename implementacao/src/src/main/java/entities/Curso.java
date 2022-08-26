package entities;

import java.util.ArrayList;

public class Curso {

	//#region ATRIBUTOS
	private String nome;
	private int creditos;
	private ArrayList<Disciplina> disciplinas;
	//#endregion

	//#region CONSTRUCTOR
	public Curso(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
	}
	//#endregion

	//#region GETTERS e SETTERS
	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	//#endregion

	//#region METODOS ESPECIFICOS
	private void adicionarDisciplina(Disciplina disciplina) {
		if(!disciplinaAdicionada(disciplina)) {
			this.creditos += disciplina.getCreditos();
			this.disciplinas.add(disciplina);
		}
	}

	private boolean removerDisciplina(Disciplina disciplina) {
		if(disciplinaAdicionada(disciplina)) {
			this.creditos -= disciplina.getCreditos();
		}
		return this.disciplinas.remove(disciplina);
	}

	private boolean disciplinaAdicionada(Disciplina disciplina) {
		return this.disciplinas.stream().anyMatch(d -> d.equals(disciplina));
	}
	//#endregion


}
