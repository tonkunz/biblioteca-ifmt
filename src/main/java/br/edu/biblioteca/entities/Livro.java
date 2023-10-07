package br.edu.biblioteca.entities;

import java.util.UUID;

public class Livro {
    
    private String id;
    private String titulo;
    private String autor;
    private String isbn;
    private String resumo;


    public Livro() {
        this.id = UUID.randomUUID().toString();
    }


    public Livro(String titulo, String autor, String isbn, String resumo) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.resumo = resumo;
    }
    

    //
    //
    // Accessors
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
