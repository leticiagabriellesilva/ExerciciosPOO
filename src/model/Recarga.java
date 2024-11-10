package model;

import java.time.LocalDate;

public class Recarga {
    private LocalDate data;
    private float valor;

    public Recarga(LocalDate data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Valor: R$ " + valor;
    }
}