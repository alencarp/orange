package br.com.zup.orange.repository;


import br.com.zup.orange.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
