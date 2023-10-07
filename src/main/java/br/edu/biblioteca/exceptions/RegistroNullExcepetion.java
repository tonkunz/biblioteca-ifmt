package br.edu.biblioteca.exceptions;

public class RegistroNullExcepetion extends RuntimeException {
    
    public RegistroNullExcepetion() {
        super("Registro não encontrado.");
    }

     public RegistroNullExcepetion(String mensagem) {
        super(mensagem);
    }
}
