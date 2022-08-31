package entities;

import java.util.ArrayList;

public class Professor extends Usuario {

	//#region ATRIBUTOS
	private int codigo_prof;
	private ArrayList<OfertaDisciplina> ofertas;
	//#endregion
	
	//#region CONSTRUCTOR
	public Professor(String nome, String senha) {
		super(nome, senha, TipoUsuario.PROFESSOR);
	}
	//#endregion

	public Professor() {
		super ();
	}

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
