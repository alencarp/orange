package br.com.zup.orange.service;

import br.com.zup.orange.domain.User;
import br.com.zup.orange.repository.UserRepository;
import br.com.zup.orange.requests.UserPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public User save(UserPostRequestBody userPostRequestBody){
        return userRepository.save(userPostRequestBody.build());
    }

}