package com.melnyk.chat.service;

import com.melnyk.chat.model.Chat;
import com.melnyk.chat.model.Message;
import com.melnyk.chat.repository.ChatRepository;
import com.melnyk.chat.repository.MessageRepository;
import com.melnyk.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends AbstractModelService<Message, Long>{
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageRepository getRepository() {
        return repository;
    }

    public List<Message> list() {
        return repository.findAll();
    }
}
