package entities;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Usuario {

	//#region ATRIBUTOS
	private int codigo_prof;
	private ArrayList<OfertaDisciplina> ofertas;
	//#endregion
	
	//#region CONSTRUCTOR
	public Professor(String nome, Date data_nascimento, String endereco) {
		super(nome, data_nascimento, endereco);
	}
	//#endregion

	//#region GETTERS e SETTERS
	public int getCodigo_prof() {
		return codigo_prof;
	}

	public ArrayList<OfertaDisciplina> getOfertas() {
		return ofertas;
	}
	//#endregion

	//#region METODOS ESPECIFICOS
	public ArrayList<Aluno> listarAlunosPorOferta(OfertaDisciplina oferta) {
		throw new Error("Not implemented");
	}
	//#endregion




}
