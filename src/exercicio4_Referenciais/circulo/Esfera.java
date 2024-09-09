package exercicio4_Referenciais.circulo;

public class Esfera {
    float r;

    public Esfera(float r) {
        this.r = r;
    }

    public void setRaio(float r){
        this.r = r;
    }

    public float calcularVolume(){
        double vol = (4/3) * Math.PI * Math.pow(r, 3);
        return (float) vol;
    }

    public float calcularArea(){
        double area = 4 * Math.PI * Math.pow(r, 2);
        return (float) area;
    }

    public static void main(String[] args) {
        Esfera esfera = new Esfera(4.0f);

        System.out.println("Volume: " + esfera.calcularVolume());
        System.out.println("Area: " + esfera.calcularArea());
    }
}
