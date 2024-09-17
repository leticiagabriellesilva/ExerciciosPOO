package Exercico_heranca;

public class C extends B {

    public C(){
        super();
        System.out.println("Construtor de Exercico_heranca.C");
    }

    public C(String mensagem){
        super(mensagem);
        System.out.println("Contrutor de Exercico_heranca.C com argumento: " + mensagem);
    }

    @Override
    public void a10() {
        System.out.println("Metodo a10 sobreposto na classe Exercico_heranca.C");
    }

    public void c10() {
        System.out.println("Metodo c10 na classe Exercico_heranca.C");
    }

}
