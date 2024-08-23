```mermaid

---
title: Biblioteca
---
classDiagram
    class Funcionario 
    
    class Bibliotecario {
        +gerenciarLivros()
    }
    Bibliotecario <|-- Funcionario
    class Leitor {
        +pegarEmprestado()
        +devolverLivros()
    }
