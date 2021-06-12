package br.com.zup.orange.repository;


import br.com.zup.orange.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
