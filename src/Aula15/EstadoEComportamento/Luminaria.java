package Aula15.EstadoEComportamento;

public class Luminaria {
    public boolean estado;
    private int intensidade;

    public Luminaria(){
        this.estado = false;
        this.intensidade = 0;
    }

    public void ligar(){
        this.estado = true;
    }
    public void desligar(){
        this.estado = false;
    }

    public void ajustarIntensidade(int intensidade){
        this.intensidade = intensidade;
    }

    public boolean getEstado(){
        return this.estado;
    }

    public int getIntensidade(){
        return this.intensidade;
    }

}
