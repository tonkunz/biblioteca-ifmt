package br.edu.biblioteca.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    
    @Id
    private String id;
    private String titulo;
    private String autor;


    public Livro() {
        this.id = UUID.randomUUID().toString();
    }


    public Livro(String titulo, String autor) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
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
}
