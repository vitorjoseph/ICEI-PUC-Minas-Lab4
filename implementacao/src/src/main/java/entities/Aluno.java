package entities;

import java.util.ArrayList;
import java.util.Date;

public class Aluno extends Usuario {

	//#region ATRIBUTOS
	//#endregion

	//#region CONSTRUCTOR
	//#endregion

	//#region GETTERS e SETTERS
	//#endregion

	//#region METODOS ESPECIFICOS
	//#endregion

	private int codigo_aluno;
	private Curso curso;
	private ArrayList<Matricula> matriculas;

	public Aluno(String nome, Date data_nascimento, String endereco) {
		super(nome, data_nascimento, endereco);
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void efetuarMatricula(ArrayList<OfertaDisciplina> ofertas) {
		this.matriculas.add(new Matricula(this, ofertas));
	}

	public void cancelarMatricula(Matricula matricula) {
		this.matriculas.remove(matricula);
	}

	public void solicitarMatricula() {
		throw new Error("Not implemented!");
	}

	public void cancelarMatricula() {
		throw new Error("Not implemented!");
	}

	public void alterarMatricula() {
		throw new Error("Not implemented!");
	}

}
