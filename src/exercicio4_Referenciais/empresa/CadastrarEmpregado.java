package exercicio4_Referenciais.empresa;

import java.util.Scanner;

public class CadastrarEmpregado {
    public static void main(String[] args) {
        Empregado empregado = new Empregado();
        Empresa empresa = new Empresa();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a razao social da empresa: ");
        empresa.setRazaoSocial(scan.nextLine());

        System.out.println("Digite o CNPJ da empresa: ");
        empresa.setCnpj(scan.nextLine());

        System.out.println("Digite o telefone da empresa: ");
        empresa.setFone(scan.nextLine());

        System.out.println("Digite o nome do funcionário: ");
        empregado.setNome(scan.nextLine());

        System.out.println("Digite o salario do funcionário: ");
        empregado.setSalario(scan.nextDouble());

        empregado.setEmpresa(empresa);

        System.out.println("Dados do funcionario - "
                + "\n Nome: " + empregado.getNome()
                + "\n Salario: " + empregado.getSalario());
        System.out.println("Dados da empresa - "
                + "\n Razao Social: " + empresa.getRazaoSocial()
                + "\n CNPJ: " + empresa.getCnpj()
                + "\n Telefone: " + empresa.getFone());

        scan.close();

    }
}
