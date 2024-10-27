package Interfaces.pessoas;

import Interfaces.autenticacao.Autenticavel;

class Cliente implements Autenticavel {
    private String senha;

    public Cliente(String senha) {
        this.senha = senha;
    }
    public boolean autentica(String senha) {
        return this.senha.equals(senha);
    }
}