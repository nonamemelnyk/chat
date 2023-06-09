package com.melnyk.chat.service;

import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractModelService<User, Long>{

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRepository getRepository() {
        return repository;
    }

    public List<User> list() {
        return repository.findAll();
    }

    public Optional<User> findByLogin(String login){
        return repository.findUserByLogin(login);
    }
}
