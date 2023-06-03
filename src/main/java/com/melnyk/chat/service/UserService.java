package com.melnyk.chat.service;

import com.melnyk.chat.model.User;
import com.melnyk.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractModelService<User, Long>{

    private final UserRepository repository;

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
