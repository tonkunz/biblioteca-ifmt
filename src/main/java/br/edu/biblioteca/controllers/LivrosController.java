package br.edu.biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.entities.Livro;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    List<Livro> listaLivros = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro novoLivro) {
        this.listaLivros.add(novoLivro);

        return ResponseEntity.status(201).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(200).body(this.listaLivros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> buscar(@PathVariable String id) {
        Optional<Livro> livroSelecionado = this.listaLivros
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (!livroSelecionado.isPresent()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(livroSelecionado.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> editar(@PathVariable String id, @RequestBody Livro livroEditado) {
        Optional<Livro> livroSelecionado = this.listaLivros
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (!livroSelecionado.isPresent()) {
            return ResponseEntity.status(404).build();
        }

        livroSelecionado.get().setAutor(livroEditado.getAutor());
        livroSelecionado.get().setTitulo(livroEditado.getTitulo());
        livroSelecionado.get().setIsbn(livroEditado.getIsbn());
        livroSelecionado.get().setResumo(livroEditado.getResumo());

        return ResponseEntity.status(200).body(livroSelecionado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable String id) {
        this.listaLivros = this.listaLivros
            .stream()
            .filter(item -> !item.getId().equals(id))
            .toList();
        
        return ResponseEntity.status(204).build();
    }
}
