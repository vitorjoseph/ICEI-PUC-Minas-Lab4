package entities;

import java.util.ArrayList;
import java.util.Date;

public class Aluno extends Usuario {

	private ArrayList<Matricula> matriculas;

	private Curso curso;

	public Aluno(String nome, Date data_nascimento, String endereco) {
		super(nome, data_nascimento, endereco);
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void efetuarMatricula(ArrayList<Disciplina> disciplinas) {
		this.matriculas.add(new Matricula(this, disciplinas));
	}

	public void cancelarMatricula(Matricula matricula) {
		this.matriculas.remove(matricula);
	}

}
