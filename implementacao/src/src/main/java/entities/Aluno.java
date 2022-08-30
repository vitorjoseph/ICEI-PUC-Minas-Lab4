package entities;

import java.util.ArrayList;
import java.util.Date;

public class Aluno extends Usuario {

	//#region ATRIBUTOS
	private int codigo_aluno;
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

	public Curso getCurso() {
		return curso;
	}
	//#endregion

	//#region METODOS ESPECIFICOS
	public void solicitarMatricula(ArrayList<OfertaDisciplina> ofertas, int ano, int semestre) {
		this.matriculas.add(new Matricula(this, ofertas, ano, semestre));
	}

	public void cancelarMatricula(Matricula matricula) {
		this.matriculas.remove(matricula);
		matricula.cancelarMatricula();
	}

	public void alterarMatricula(Matricula matricula, OfertaDisciplina ofertaAtual, OfertaDisciplina novaOferta){
		throw new Error("Not implemented!");
	}
	//#endregion
}





