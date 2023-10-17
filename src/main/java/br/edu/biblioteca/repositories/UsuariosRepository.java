package br.edu.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.biblioteca.entities.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, String> {
    
    Usuario findByNomeUsuario(String nomeUsuario);
}
