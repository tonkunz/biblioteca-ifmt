package br.edu.biblioteca.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.biblioteca.entities.Livro;
import br.edu.biblioteca.exceptions.RegistroNullExcepetion;

@Service
public class LivrosService {
    
    List<Livro> listaLivros = new ArrayList<>();

    public Livro criarLivro(Livro novoLivro) {
        listaLivros.add(novoLivro);

        return novoLivro;
    }

    public List<Livro> listarLivros() {
        return listaLivros;
    }

    public Livro buscarLivro(String id) {
        Optional<Livro> livroSelecionado = this.listaLivros
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (!livroSelecionado.isPresent()) {
            throw new RegistroNullExcepetion();
        }

        return livroSelecionado.get();
    }

    public Livro editarLivro(String id, Livro livroEditado) {
        Optional<Livro> livroSelecionado = this.listaLivros
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (!livroSelecionado.isPresent()) {
            return null;
        }

        livroSelecionado.get().setAutor(livroEditado.getAutor());
        livroSelecionado.get().setTitulo(livroEditado.getTitulo());
        livroSelecionado.get().setIsbn(livroEditado.getIsbn());
        livroSelecionado.get().setResumo(livroEditado.getResumo());

        return livroSelecionado.get();
    }

    public void excluirLivro(String id) {
        this.listaLivros = this.listaLivros
            .stream()
            .filter(item -> !item.getId().equals(id))
            .toList();
    }
 }
