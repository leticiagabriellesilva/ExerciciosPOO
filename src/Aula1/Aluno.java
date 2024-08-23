package Aula1;

public class Aluno extends Usuario {
    private int matricula;
    private String curso;

    public Aluno(String login, String senha, int matricula, String curso) {
        super(login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    public void matricularSe() {
        System.out.println("Aula1.Aluno matriculado no curso: " + this.curso);
    }

    public void trancarMatricula() {
        System.out.println("Matrícula trancada para o curso: " + this.curso);
    }
}
