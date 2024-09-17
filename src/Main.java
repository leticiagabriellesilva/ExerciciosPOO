public class Main {
    public static void main(String[] args) {
        C objC = new C();
        objC.a10();
        objC.b20();
        objC.c10();

        System.out.println("Construtores com argumento: ");
        C objComArg = new C("Exemplo");
        objComArg.a10();
        objComArg.b20();
        objComArg.c10();
    }
}
