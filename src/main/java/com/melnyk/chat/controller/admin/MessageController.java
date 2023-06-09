package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.domain.Message;
import com.melnyk.chat.service.AbstractModelService;
import com.melnyk.chat.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/message")
@AllArgsConstructor
public class MessageController extends AbstractModelController<Message, Long> {

    private MessageService messageService;

    @Override
    public AbstractModelService<Message, Long> getModelService() {
        return messageService;
    }
//    public MessageController(AbstractModelService<Message, Long> modelService) {
//        super(modelService);
//    }
}