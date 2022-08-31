package entities;

import excecao.TipoInvalidoExcecao;

public class UsuarioFactory { //Factory method

	public static Usuario creator( String tipo) throws TipoInvalidoExcecao {
				
		Usuario Usuario = null;

		if (tipo.equalsIgnoreCase("aluno")) {
			Usuario = new Aluno();
		}
		else if (tipo.equalsIgnoreCase("professor")) {
			Usuario = new Professor();
		}

		else {
			throw new TipoInvalidoExcecao(" O " + tipo+ " não é um tipo válido para Usuario");
		}
		return Usuario;
	}
}
