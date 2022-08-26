package entities;

import java.util.ArrayList;

public class Matricula {

	//#region ATRIBUTOS
	private int codigo_matricula;
	private Aluno aluno;
	private ArrayList<OfertaDisciplina> ofertas;
	private int ano;
	private int semestre;
	private boolean concluida;
	//#endregion

	//#region CONSTRUCTOR
	public Matricula(Aluno aluno, ArrayList<OfertaDisciplina> ofertas ) {
		if (validarSolicitacaoMatricula()) {
			this.aluno = aluno;
			this.ofertas = ofertas;
			this.codigo_matricula = gerarCodigoMatricula();
		}
	}

	// método para validar a quantidade de disciplinas obrigatórias e não obrigatórias
	public boolean validarSolicitacaoMatricula() {
		return false;
	}
	private int gerarCodigoMatricula() {
		return 0;
	}
	//#endregion

	//#region GETTERS e SETTERS
	public int getCodigo_matricula() {
		return codigo_matricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public ArrayList<OfertaDisciplina> getOfertas() {
		return ofertas;
	}

	public int getAno() {
		return ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public boolean isConcluida() {
		return concluida;
	}

	//#endregion

	//#region METODOS ESPECIFICOS


	// método para concluir a matrícula apos o prazo de matrícula,
	// e verificar quais as ofertas possuem a quantidade necessária de alunos
	// as ofertas que não possuírem são excluidas da matrícula
	public void concluirMatricula() {

	}

	//#endregion

}
