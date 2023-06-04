package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.service.AbstractModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/chat")
public class ChatController extends AbstractModelController<Chat, Long> {

    public ChatController(AbstractModelService<Chat, Long> modelService) {
        super(modelService);
    }
}
