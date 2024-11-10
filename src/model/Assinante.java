package model;

public class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    private Chamada[] chamadas;
    private int numChamadas;

    public Assinante(long cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[100];
        this.numChamadas = 0;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
}