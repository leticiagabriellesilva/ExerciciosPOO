package PACKAGE_NAME;
import java.time.LocalTime;

public class Funcionario extends Usuario {
    private int numFuncional;

    public Funcionario(String login, String senha, int numFuncional) {
        super(login, senha);
        this.numFuncional = numFuncional;
    }

    public void registrarHorario(String hora) {
        LocalTime horario = LocalTime.parse(hora);
        System.out.println("Horário de trabalho registrado às: " + horario);
    }
