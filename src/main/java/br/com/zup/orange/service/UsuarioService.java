package br.com.zup.orange.service;

import br.com.zup.orange.domain.Usuario;
import br.com.zup.orange.repository.UsuarioRepository;
import br.com.zup.orange.dto.UsuarioPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody){
        return usuarioRepository.save(usuarioPostRequestBody.build());
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Long usuarioId) {
//        Usuario usuario = usuarioService.findById(usuarioId).get();
        return usuarioRepository.findById(usuarioId);
    }
}