public class C extends B{

    public C(){
        super();
        System.out.println("Construtor de C");
    }

    public C(String mensagem){
        super(mensagem);
        System.out.println("Contrutor de C com argumento: " + mensagem);
    }

    @Override
    public void a10() {
        System.out.println("Metodo a10 sobreposto na classe C");
    }

    public void c10() {
        System.out.println("Metodo c10 na classe C");
    }

}
