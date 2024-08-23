package Aula1;

public class Escola {
    public static void main(String[] args) {
        // aluno
        Aluno aluno = new Aluno("alunoLogin", "alunoSenha", 12345, "Analise e Desenvolvimento de Sistemas");
        aluno.matricularSe();

        // funcionário
        Funcionario funcionario = new Funcionario("funcLogin", "funcSenha", 67890);
        funcionario.registrarHorario("22:00");

        // professor
        Professor professor = new Professor("profLogin", "profSenha", 54321, "Doutor em Computação");
        professor.digitarNotas(6);
    }

}
