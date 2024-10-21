package Banco;

import java.util.ArrayList;

public class Banco {
    private int numInstrumentos;
    private ArrayList<InstrumentoFinanceiro> instrumentos;

    public Banco() {
        instrumentos = new ArrayList<>();
        numInstrumentos = 0;
    }

    public void adicionar(InstrumentoFinanceiro instrumento) {
        instrumentos.add(instrumento);
        numInstrumentos++;
    }

    public float calcularSaldos() {
        float saldoTotal = 0;
        for (InstrumentoFinanceiro instrumento : instrumentos) {
            saldoTotal += instrumento.calcularSaldoTotal();
        }
        return saldoTotal;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        Acao acao = new Acao();
        acao.setSaldo(150);
        acao.setCotas(10);

        ContaCorrente conta = new ContaCorrente();
        conta.setSaldo(300);
        conta.setLimite(110);

        FundoDeAplicacao fundo = new FundoDeAplicacao();
        fundo.setSaldo(2000);
        fundo.setRentabilidade(0.04f);

        banco.adicionar(acao);
        banco.adicionar(conta);
        banco.adicionar(fundo);

        System.out.println("Saldo total no banco: " + banco.calcularSaldos());
    }
}
