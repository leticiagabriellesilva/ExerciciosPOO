package Aula15.CriacaoDeObjetos;

import Aula15.definicaoDeCarro.Carro;

public class Carros {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", "Corolla", 2020, "Preto");
        Carro carro2 = new Carro("Honda", "Civic", 2022, "Prata");

        System.out.println("Carro 1: ");
        System.out.println(carro1.getMarcaCarro());
        System.out.println(carro1.getModeloCarro());
        System.out.println(carro1.getAnoCarro());
        System.out.println(carro1.getCorCarro());
        System.out.println("Carro 2: ");
        System.out.println(carro2.getMarcaCarro());
        System.out.println(carro2.getModeloCarro());
        System.out.println(carro2.getAnoCarro());
        System.out.println(carro2.getCorCarro());
    }
}
