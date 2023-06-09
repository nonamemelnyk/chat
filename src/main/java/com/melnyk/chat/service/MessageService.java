package com.melnyk.chat.service;

import com.melnyk.chat.model.domain.Message;
import com.melnyk.chat.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends AbstractModelService<Message, Long>{
    private MessageRepository repository;

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
