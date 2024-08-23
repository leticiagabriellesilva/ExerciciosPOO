package Aula15.EstadoEComportamento;

public class Luminarias {
    public static void EstadoLuminaria(boolean estado) {
        if (estado){
            System.out.println("Ligado!");
        } else {
            System.out.println("Desligado!");
        }
    }

    public static void main(String[] args) {
        Luminaria luminaria = new Luminaria();
        luminaria.ligar();
        EstadoLuminaria(luminaria.getEstado());
        luminaria.ajustarIntensidade(20);
        System.out.println(luminaria.getIntensidade());
        luminaria.desligar();
        EstadoLuminaria(luminaria.getEstado());
    }
}
