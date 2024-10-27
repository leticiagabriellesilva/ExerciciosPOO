package Interfaces.pessoas;

import Interfaces.autenticacao.Autenticavel;

class Gerente extends Funcionario implements Autenticavel {
    private String senha;

    public Gerente(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String senha) {
        return this.senha.equals(senha);
    }
}
