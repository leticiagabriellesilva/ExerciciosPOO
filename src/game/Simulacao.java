package game;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacao {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Random random = new Random();
    private final int MAX_RODADAS = 1000;

    public Simulacao(Tabuleiro tabuleiro, List<Jogador> jogadores) {
        this.tabuleiro = tabuleiro;
        this.jogadores = jogadores;
    }

    public void rodarSimulacao(int numPartidas) {
        int rodadasTotais = 0;
        int partidasTimeout = 0;
        int[] vitorias = new int[jogadores.size()];

        for (int i = 0; i < numPartidas; i++) {
            resetarJogadores();
            int rodadas = jogarPartida();
            rodadasTotais += rodadas;
            if (rodadas >= MAX_RODADAS) {
                partidasTimeout++;
            }
            Jogador vencedor = determinarVencedor();
            if (vencedor != null) {
                vitorias[jogadores.indexOf(vencedor)]++;
            }
        }

        imprimirResultados(numPartidas, rodadasTotais, partidasTimeout, vitorias);
    }

    private void resetarJogadores() {
        for (Jogador jogador : jogadores) {
            jogador.resetar();
        }
    }

    private int jogarPartida() {
        int rodada = 0;
        while (jogoEmAndamento() && rodada < MAX_RODADAS) {
            for (Jogador jogador : jogadores) {
                if (jogador.isAtivo()) {
                    jogarTurno(jogador);
                }
            }
            rodada++;
        }
        return rodada;
    }

    private void jogarTurno(Jogador jogador) {
        int passos = random.nextInt(6) + 1;
        jogador.mover(passos);
        Propriedade propriedade = tabuleiro.getPropriedade(jogador.getPosicaoAtual());

        if (propriedade.temDono()) {
            jogador.removerCoins(propriedade.getValorAluguel());
            propriedade.getDono().adicionarCoins(propriedade.getValorAluguel());
        } else if (jogador.decidirCompra(propriedade) && jogador.getCoins() >= propriedade.getValorVenda()) {
            jogador.removerCoins(propriedade.getValorVenda());
            propriedade.setDono(jogador);
        }

        if (jogador.getPosicaoAtual() == 0) {
            jogador.adicionarCoins(100);
        }
    }

    private boolean jogoEmAndamento() {
        int jogadoresAtivos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador.isAtivo()) {
                jogadoresAtivos++;
            }
        }
        return jogadoresAtivos > 1;
    }

    private Jogador determinarVencedor() {
        Jogador vencedor = null;
        int maiorCoins = -1;
        for (Jogador jogador : jogadores) {
            if (jogador.isAtivo() && jogador.getCoins() > maiorCoins) {
                maiorCoins = jogador.getCoins();
                vencedor = jogador;
            }
        }
        return vencedor;
    }

    private void imprimirResultados(int numPartidas, int rodadasTotais, int partidasTimeout, int[] vitorias) {
        System.out.println("Número de partidas terminadas por timeout: " + partidasTimeout);
        System.out.println("Média de rodadas por partida: " + (rodadasTotais / numPartidas));
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println("Vitórias do " + jogadores.get(i).getNome() + ": " + vitorias[i]);
        }

        int maxVitorias = -1;
        String comportamentoMaisVitorioso = "";
        for (int i = 0; i < jogadores.size(); i++) {
            if (vitorias[i] > maxVitorias) {
                maxVitorias = vitorias[i];
                comportamentoMaisVitorioso = jogadores.get(i).getNome();
            }
        }
        System.out.println("Comportamento que mais vence: " + comportamentoMaisVitorioso);
    }

    public static void main(String[] args) {
        List<Propriedade> propriedades = lerPropriedades("src/gameConfig.txt");
        Tabuleiro tabuleiro = new Tabuleiro(propriedades);

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Impulsivo", Jogador.Comportamento.IMPULSIVO));
        jogadores.add(new Jogador("Exigente", Jogador.Comportamento.EXIGENTE));
        jogadores.add(new Jogador("Cauteloso", Jogador.Comportamento.CAUTELOSO));
        jogadores.add(new Jogador("Aleatório", Jogador.Comportamento.ALEATORIO));

        Simulacao simulacao = new Simulacao(tabuleiro, jogadores);
        simulacao.rodarSimulacao(300);
    }

    private static List<Propriedade> lerPropriedades(String arquivo) {
        List<Propriedade> propriedades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] partes = linha.split("\\s+");
                    int valorVenda = Integer.parseInt(partes[0]);
                    int valorAluguel = Integer.parseInt(partes[1]);
                    propriedades.add(new Propriedade(valorVenda, valorAluguel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propriedades;
    }
}