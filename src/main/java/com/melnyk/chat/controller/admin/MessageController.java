package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.Message;
import com.melnyk.chat.model.User;
import com.melnyk.chat.service.AbstractModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/message")
public class MessageController extends AbstractModelController<Message, Long> {

    public MessageController(AbstractModelService<Message, Long> modelService) {
        super(modelService);
    }
}