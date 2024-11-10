package service;

import model.PrePago;
import model.PosPago;

import java.time.LocalDate;
import java.util.Scanner;

public class Telefonia {

    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {
        prePagos = new PrePago[100];
        numPrePagos = 0;
        posPagos = new PosPago[100];
        numPosPagos = 0;
    }

    public void cadastrarAssinante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de assinante (1 para Pré-Pago, 2 para Pós-Pago): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o nome do assinante: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o número de telefone do assinante: ");
        String numero = scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Digite o valor de créditos iniciais: ");
            float creditos = scanner.nextFloat();
            prePagos[numPrePagos] = new PrePago(cpf, nome, numero, creditos);
            numPrePagos++;
            System.out.println("Assinante Pré-Pago cadastrado com sucesso.");
        } else if (tipo == 2) {
            System.out.println("Digite o valor da assinatura: ");
            float assinatura = scanner.nextFloat();
            posPagos[numPosPagos] = new PosPago(cpf, nome, numero, assinatura);
            numPosPagos++;
            System.out.println("Assinante Pós-Pago cadastrado com sucesso.");
        } else {
            System.out.println("Tipo de assinante inválido.");
        }
    }

    public void listarAssinantes() {
        System.out.println("Lista de assinantes pré-pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(prePagos[i].toString());
        }

        System.out.println("Lista de assinantes pós-pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println(posPagos[i].toString());
        }
    }

    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de assinante (1 para Pré-Pago, 2 para Pós-Pago): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        if (tipo == 1) {
            PrePago assinante = localizarPrePago(cpf);
            if (assinante != null) {
                System.out.println("Digite a data da chamada (formato: ano-mês-dia): ");
                String dataStr = scanner.nextLine();
                LocalDate data = LocalDate.parse(dataStr);
                System.out.println("Digite a duração da chamada em minutos: ");
                int duracao = scanner.nextInt();
                assinante.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante Pré-Pago não encontrado.");
            }
        } else if (tipo == 2) {
            PosPago assinante = localizarPosPago(cpf);
            if (assinante != null) {
                System.out.println("Digite a data da chamada (formato: ano-mês-dia): ");
                String dataStr = scanner.nextLine();
                LocalDate data = LocalDate.parse(dataStr);
                System.out.println("Digite a duração da chamada em minutos: ");
                int duracao = scanner.nextInt();
                assinante.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante Pós-Pago não encontrado.");
            }
        } else {
            System.out.println("Tipo de assinante inválido.");
        }
    }

    public void fazerRecarga() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do assinante Pré-Pago: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        PrePago assinante = localizarPrePago(cpf);
        if (assinante != null) {
            System.out.println("Digite o valor da recarga: ");
            float valor = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Digite a data da recarga (formato: ano-mês-dia): ");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr);
            assinante.recarregar(data, valor);
        } else {
            System.out.println("Assinante Pré-Pago não encontrado.");
        }
    }

    public void imprimirFaturas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o mês para a fatura: ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPrePagos; i++) {
            prePagos[i].imprimirFatura(mes);
        }
        for (int i = 0; i < numPosPagos; i++) {
            posPagos[i].imprimirFatura(mes);
        }
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getCpf() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Telefonia telefonia = new Telefonia();
        boolean sair = false;

        while (!sair) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar assinante");
            System.out.println("2. Listar assinantes");
            System.out.println("3. Fazer chamada");
            System.out.println("4. Fazer recarga");
            System.out.println("5. Imprimir faturas");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    telefonia.cadastrarAssinante();
                    break;
                case 2:
                    telefonia.listarAssinantes();
                    break;
                case 3:
                    telefonia.fazerChamada();
                    break;
                case 4:
                    telefonia.fazerRecarga();
                    break;
                case 5:
                    telefonia.imprimirFaturas();
                    break;
                case 6:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}