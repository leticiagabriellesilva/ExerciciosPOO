package PACKAGE_NAME;
public class Professor extends Funcionario {
    private String titulacao;

    public Professor(String login, String senha, int numFuncional, String titulacao) {
        super(login, senha, numFuncional);
        this.titulacao = titulacao;
    }

    public void digitarNotas(int turma) {
        System.out.println("Notas digitadas para a turma " + turma);
    }
}
