package entities;

import java.util.Date;

public class Admin extends Usuario {

        //#region ATRIBUTOS
        private int codigo_admin;
        //#endregion

        //#region CONSTRUCTOR
        public Admin(String nome, String senha) {
            super(nome, senha, TipoUsuario.ADMIN);
        }
        //#endregion

        public Admin() {
            super();
        }

        //#region GETTERS e SETTERS
        public int getCodigo_admin() {
            return codigo_admin;
        }
        //#endregion

        //#region METODOS ESPECIFICOS
        //#endregion

}
