package model;

public class Jogador {
    private String nome;
    private int coins;
    private int posicaoAtual;
    private boolean ativo;
    private Comportamento comportamento;

    public enum Comportamento {
        IMPULSIVO,
        EXIGENTE,
        CAUTELOSO,
        ALEATORIO
    }

    public Jogador(String nome, Comportamento comportamento) {
        this.nome = nome;
        this.coins = 300;
        this.posicaoAtual = 0;
        this.ativo = true;
        this.comportamento = comportamento;
    }

    public String getNome() {
        return nome;
    }

    public int getCoins() {
        return coins;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void mover(int passos) {
        posicaoAtual = (posicaoAtual + passos) % 20;
    }

    public void adicionarCoins(int valor) {
        coins += valor;
    }

    public void removerCoins(int valor) {
        coins -= valor;
        if (coins < 0) {
            ativo = false;
        }
    }

    public void resetar() {
        this.coins = 300;
        this.posicaoAtual = 0;
        this.ativo = true;
    }

    public boolean decidirCompra(Propriedade propriedade) {
        switch (comportamento) {
            case IMPULSIVO:
                return true;
            case EXIGENTE:
                return propriedade.getValorAluguel() > 50;
            case CAUTELOSO:
                return this.coins - propriedade.getValorVenda() >= 80;
            case ALEATORIO:
                return Math.random() < 0.5;
            default:
                return false;
        }
    }
}