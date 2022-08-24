package entities;

import entities.Aluno;
import entities.Disciplina;

import java.util.ArrayList;

public class Oferta {

	private int ano;

	private int semestre;

	private int quantidadeAlunos;

	private Disciplina disciplina;

	private ArrayList<Aluno> alunos;

	public Oferta(Disciplina disciplina, int ano, int semestre) {
		this.disciplina = disciplina;
		this.ano = ano;
		this.semestre = semestre;
		this.alunos = new ArrayList<>();
	}

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public boolean removerAluno(Aluno aluno) {
		return this.alunos.remove(aluno);
	}
}
