package br.edu.biblioteca.services;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.exceptions.RegraDeNegocioException;
import br.edu.biblioteca.repositories.UsuariosRepository;

@Service
public class UsuarioService {
    
    private final UsuariosRepository usuariosRepository;
    private final AutenticacaoService autenticacaoService;

    public UsuarioService(UsuariosRepository usuariosRepository, AutenticacaoService autenticacaoService) {
        this.usuariosRepository = usuariosRepository;
        this.autenticacaoService = autenticacaoService;
    }

    public Usuario criarUsuario(Usuario novoUsuario) {
        UserDetails  usuarioSelecionado = autenticacaoService.loadUserByUsername(novoUsuario.getNomeUsuario());

        if (usuarioSelecionado != null) {
            throw new RegraDeNegocioException("Usuário já se encontra cadastrado");
        }
        
        novoUsuario.setSenha(new BCryptPasswordEncoder().encode(novoUsuario.getSenha()));
        novoUsuario.setId(UUID.randomUUID().toString());

        usuariosRepository.save(novoUsuario);

        return novoUsuario;
    }
}
