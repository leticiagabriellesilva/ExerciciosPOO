package Interfaces.sistema;

import Interfaces.autenticacao.Autenticavel;

class SistemaInterno {
    public boolean login(Autenticavel autenticavel, String senha) {
        return autenticavel.autentica(senha);
    }
}
