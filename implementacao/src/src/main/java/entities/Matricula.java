package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	public Matricula(Aluno aluno, ArrayList<OfertaDisciplina> ofertas, int ano, int semestre ) {
		try {
			if (validarSolicitacaoMatricula()) {
				this.aluno = aluno;
				this.ofertas = ofertas;
				this.codigo_matricula = gerarCodigoMatricula();
				this.ano = ano;
				this.semestre = semestre;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// método para validar a quantidade de disciplinas obrigatórias e não obrigatórias
	public boolean validarSolicitacaoMatricula() throws Exception {
		List<OfertaDisciplina> obrigatorias = this.ofertas.stream().filter(o -> o.getDisciplina().isObrigatoria()).toList();
		List<OfertaDisciplina> optativas = this.ofertas.stream().filter(o -> !o.getDisciplina().isObrigatoria()).toList();

		if(obrigatorias.size() > 4){
			throw new Exception("O aluno não pode se matricular em mais de 4 disciplinas obrigatórias");
		} else if (optativas.size() > 2) {
			throw new Exception("O aluno não pode se matricular em mais de 2 disciplinas optativas");
		}

		return true;
	}

	/*
	* Gerar código aleatório para matricula
	* */
	private int gerarCodigoMatricula() {
		return 0;
	}
	//#endregion

	//#region GETTERS e SETTERS
	public int getCodigo_matricula() {
		return codigo_matricula;
	}

	public int getCodigoAluno() {
		return aluno.getCodigo();
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
	public void concluirMatricula() throws Exception {
		List<OfertaDisciplina> ofertasAtivas = this.ofertas.stream().filter(OfertaDisciplina::isAtivo).toList();
		this.ofertas = (ArrayList<OfertaDisciplina>) ofertasAtivas;
		if(ofertasAtivas.size() > 0) {
			this.concluida = true;
		} else {
			throw new Exception("A matrícula foi anulada, pois todas as ofertas não estão ativas");
		}
	}

	public void cancelarMatricula() {
		if(LocalDate.now().getYear() == this.ano) {
			this.concluida = false;
			this.ofertas.forEach(o -> o.removerAluno(this.aluno));
		}
	}

	public int valorCobranca() {
		// faz a soma do preço de cada disciplina referente as ofertas presentes na matrícula
		return getOfertas().stream().mapToInt(o -> o.getDisciplina().getPreco()).sum();
	}

	//#endregion

}
