package formatos;

public class Forma2D {
    private String cor;

    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getCor() {
        return cor;
    }

    public void desenhar(){
        System.out.println("Desenhar forma");
    }

}
