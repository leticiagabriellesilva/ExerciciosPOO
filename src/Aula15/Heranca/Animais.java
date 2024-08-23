package Aula15.Heranca;

public class Animais {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();

        System.out.println(animal.fazerSom());
        System.out.println(gato.fazerSom());
        System.out.println(cachorro.fazerSom());
    }
}
