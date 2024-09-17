package Exercico_heranca;

public class B extends A {

    public B(){
        super();
    }

    public B(String mensagem){
        super(mensagem);
        System.out.println("Contrutor de Exercico_heranca.B com argumento: " + mensagem);
    }

    @Override
    public void a10() {
        System.out.println("Metodo a10 sobreposto na classe Exercico_heranca.B");
    }

    public void b20() {
        System.out.println("Metodo b20 na classe Exercico_heranca.B");
    }
}
