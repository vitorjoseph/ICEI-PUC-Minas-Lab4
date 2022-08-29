package entities;

import java.util.ArrayList;

public class OfertaDisciplina {

	//#region ATRIBUTOS
	private Disciplina disciplina;
	private Professor professor;
	private int ano;
	private int semestre;
	private ArrayList<Aluno> alunos;
	private int quantidadeAlunos;
	private boolean ativo;
	//#endregion

	//#region CONSTRUCTOR
	public OfertaDisciplina(Disciplina disciplina, int ano, int semestre, Professor professor) {
		this.disciplina = disciplina;
		this.ano = ano;
		this.semestre = semestre;
		this.professor = professor;
		this.alunos = new ArrayList<>();
		this.ativo = false;
	}
	//#endregion

	//#region GETTERS e SETTERS

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public int getAno() {
		return ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	//#endregion

	//#region METODOS ESPECIFICOS

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public boolean removerAluno(Aluno aluno) {
		return this.alunos.remove(aluno);
	}

	public boolean ativarOferta() {
		throw new Error("Not implemented!");
	}

	//#endregion
}