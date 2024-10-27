package Interfaces.pessoas;

import Interfaces.autenticacao.Autenticavel;

class Diretor extends Funcionario implements Autenticavel {
    private String senha;

    public Diretor(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String senha) {
        return this.senha.equals(senha);
    }
}