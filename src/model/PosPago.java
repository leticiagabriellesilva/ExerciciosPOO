package model;

import java.time.LocalDate;

public class PosPago extends Assinante {
    private float assinatura;
    private Chamada[] chamadas;
    private int numChamadas;

    public PosPago(long cpf, String nome, String numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
        this.chamadas = new Chamada[100];
        this.numChamadas = 0;
    }

    public void fazerChamada(LocalDate data, int duracao) {
        if (numChamadas >= chamadas.length) {
            System.out.println("Não há espaço para mais chamadas.");
            return;
        }

        chamadas[numChamadas] = new Chamada(data, duracao);
        numChamadas++;
        System.out.println("Chamada registrada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do assinante " + getNome() + " (Pós-Pago):");
        System.out.println("CPF: " + getCpf() + " | Número: " + getNumero());

        float totalChamadas = 0;
        for (int i = 0; i < numChamadas; i++) {
            if (chamadas[i].getData().getMonthValue() == mes) {
                System.out.println("Chamada em " + chamadas[i].getData() +
                        " | Duração: " + chamadas[i].getDuracao() +
                        " minutos | Custo: " + chamadas[i].getDuracao() * 1.04);
                totalChamadas += chamadas[i].getDuracao() * 1.04;
            }
        }

        System.out.println("Total de chamadas no mês: R$ " + totalChamadas);
        System.out.println("Assinatura: R$ " + assinatura);
        System.out.println("Total da fatura: R$ " + (totalChamadas + assinatura));
    }
}