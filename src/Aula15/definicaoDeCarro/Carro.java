package Aula15.definicaoDeCarro;

public class Carro {
    public String marcaCarro;
    public String modeloCarro;
    public int anoCarro;
    public String corCarro;

    public Carro(String marcaCarro, String modeloCarro, int anoCarro, String corCarro){
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
        this.anoCarro = anoCarro;
        this.corCarro = corCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public int getAnoCarro() {
        return anoCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

}
