package entities;

public enum TipoUsuario {
    ALUNO("ALUNO"),
    PROFESSOR("PROFESSOR"),
    ADMIN("ADMIN");

    private String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
}
