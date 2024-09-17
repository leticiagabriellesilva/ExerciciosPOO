public class B extends A{

    public B(){
        super();
    }

    public B(String mensagem){
        super(mensagem);
        System.out.println("Contrutor de B com argumento: " + mensagem);
    }

    @Override
    public void a10() {
        System.out.println("Metodo a10 sobreposto na classe B");
    }

    public void b20() {
        System.out.println("Metodo b20 na classe B");
    }
}
