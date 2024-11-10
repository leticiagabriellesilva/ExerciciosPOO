package model;

import java.time.LocalDate;

public class PrePago extends Assinante {
    private float creditos;
    private Recarga[] recargas;
    private int numRecargas;

    private Chamada[] chamadas;
    private int numChamadas;

    public PrePago(long cpf, String nome, String numero, float creditos) {
        super(cpf, nome, numero);
        this.creditos = creditos;
        this.chamadas = new Chamada[100];
        this.numChamadas = 0;
        this.recargas = new Recarga[100];
        this.numRecargas = 0;
    }

    public void fazerChamada(LocalDate data, int duracao) {
        if (numChamadas >= chamadas.length) {
            System.out.println("Não há espaço para mais chamadas.");
            return;
        }

        if (creditos < duracao * 1.45) {
            System.out.println("Créditos insuficientes.");
            return;
        }

        chamadas[numChamadas] = new Chamada(data, duracao);
        numChamadas++;
        creditos -= duracao * 1.45;
        System.out.println("Chamada registrada com sucesso!");
    }

    public void recarregar(LocalDate data, float valor) {
        if (numRecargas >= recargas.length) {
            System.out.println("Não há espaço para mais recargas.");
            return;
        }

        recargas[numRecargas] = new Recarga(data, valor);
        numRecargas++;
        creditos += valor;
        System.out.println("Recarga realizada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do assinante " + getNome() + " (Pré-Pago):");
        System.out.println("CPF: " + getCpf() + " | Número: " + getNumero());

        float totalChamadas = 0;
        for (int i = 0; i < numChamadas; i++) {
            if (chamadas[i].getData().getMonthValue() == mes) {
                System.out.println("Chamada em " + chamadas[i].getData() +
                        " | Duração: " + chamadas[i].getDuracao() +
                        " minutos | Custo: " + chamadas[i].getDuracao() * 1.45);
                totalChamadas += chamadas[i].getDuracao() * 1.45;
            }
        }

        float totalRecargas = 0;
        for (int i = 0; i < numRecargas; i++) {
            if (recargas[i].getData().getMonthValue() == mes) {
                System.out.println("Recarga em " + recargas[i].getData() +
                        " | Valor: " + recargas[i].getValor());
                totalRecargas += recargas[i].getValor();
            }
        }

        System.out.println("Total de chamadas no mês: R$ " + totalChamadas);
        System.out.println("Total de recargas no mês: R$ " + totalRecargas);
        System.out.println("Créditos restantes: R$ " + creditos);
    }
}