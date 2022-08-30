package entities;

import java.util.ArrayList;
import java.util.Date;

public class Aluno extends Usuario {

	//#region ATRIBUTOS
	private int codigoAluno;
	private Curso curso;
	private ArrayList<Matricula> matriculas;
	//#endregion

	//#region CONSTRUCTOR
	public Aluno(String nome, Date data_nascimento, String endereco) {
		super(nome, data_nascimento, endereco);
	}
	//#endregion

	//#region GETTERS e SETTERS
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public int getCodigo() {
		return codigoAluno;
	}

	public Curso getCurso() {
		return curso;
	}
	//#endregion

	//#region METODOS ESPECIFICOS
	public void solicitarMatricula(ArrayList<OfertaDisciplina> ofertas, int ano, int semestre) {
		this.matriculas.add(new Matricula(this, ofertas, ano, semestre));
	}

	public void cancelarMatricula(Matricula matricula) throws Exception {
		if(getMatriculas().contains(matricula) && matricula.getCodigoAluno() == this.getCodigo()) {
			this.matriculas.remove(matricula);
			matricula.cancelarMatricula();
		} else {
			throw new Exception("Matricula inexistente!");
		}
	}

	public void alterarMatricula(Matricula matricula, OfertaDisciplina ofertaAtual, OfertaDisciplina novaOferta){
		throw new Error("Not implemented!");
	}

	public void gerarCobranca(Matricula matricula) throws Exception {
		if(getMatriculas().contains(matricula)){
			matricula.valorCobranca();
		}
		throw new Exception("Not Implemented!");
	}
	//#endregion
}





