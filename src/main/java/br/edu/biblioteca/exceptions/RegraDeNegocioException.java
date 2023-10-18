package br.edu.biblioteca.exceptions;

public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException() {
        super("Houve um problema. Entre em contato com o suporte");
    }
    
    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}
