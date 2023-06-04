package com.melnyk.chat.service;

import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatService extends AbstractModelService<Chat, Long> {

    private final ChatRepository repository;

    public ChatService(ChatRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatRepository getRepository() {
        return repository;
    }

    public List<Chat> list() {
        return repository.findAll();
    }

    public List<Chat> findAllByUser(User user) {
        return repository.findAllByUsersContains(user);
    }

}

