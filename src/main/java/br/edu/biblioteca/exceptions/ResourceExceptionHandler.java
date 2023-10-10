package br.edu.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.biblioteca.entities.Erro;

@RestControllerAdvice
public class ResourceExceptionHandler {
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public Erro tratarException(RegistroNaoEncontradoException exception) {
        String mensagem = exception.getMessage();
        return new Erro(mensagem);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Erro tratarException(MethodArgumentNotValidException exception) {
        return new Erro("Erro...");
    }
}
