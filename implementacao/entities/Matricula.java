package entities;

import entities.Aluno;
import entities.Disciplina;

import java.util.ArrayList;

public class Matricula {

	private int codigo_matricula;
	private Aluno aluno;
	private ArrayList<Disciplina> disciplinas;
	private int ano;
	private enum semestre {

	}

	public Matricula(Aluno aluno, ArrayList<Disciplina> disciplinas ) {
		if (validarDisciplinas()) {
			this.aluno = aluno;
			this.disciplinas = disciplinas;
			this.codigo_matricula = gerarCodigoMatricula();
		}
	}

	private boolean validarDisciplinas() {
		return false;
	}

	private int gerarCodigoMatricula() {
		return 0;
	}
}
