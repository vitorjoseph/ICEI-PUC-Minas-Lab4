package entities;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Usuario {

	//#region ATRIBUTOS
	//#endregion

	//#region CONSTRUCTOR
	//#endregion

	//#region GETTERS e SETTERS
	//#endregion

	//#region METODOS ESPECIFICOS
	//#endregion

	private int codigo_prof;
	private ArrayList<OfertaDisciplina> ofertas;

	public Professor(String nome, Date data_nascimento, String endereco) {
		super(nome, data_nascimento, endereco);
	}

	public ArrayList<Aluno> listarAlunosPorOferta(OfertaDisciplina oferta) {
		throw new Error("Not implemented");
	}

}
