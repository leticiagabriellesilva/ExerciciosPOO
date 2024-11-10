package model;

import java.time.LocalDate;

public class Chamada {
    private LocalDate data;
    private int duracao;

    public Chamada(LocalDate data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public LocalDate getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Duração: " + duracao + " minutos";
    }
}