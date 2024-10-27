package Formatos;

public class Main {
    public static void main(String[] args) {
        Forma2D formaA = new Circulo();
        Forma2D formaB = new Quadrado();
        Forma2D formaC = new Triangulo();

        Desenho desenhar = new Desenho();
        desenhar.ilustrar(formaA);
        desenhar.ilustrar(formaB);
        desenhar.ilustrar(formaC);
    }
}
