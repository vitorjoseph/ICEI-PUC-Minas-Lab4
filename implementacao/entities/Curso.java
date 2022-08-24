package entities;

import java.util.ArrayList;

public class Curso {

	private String nome;
	private int creditos;
	private ArrayList<Disciplina> disciplinas;

	public Curso(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
	}

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
}
