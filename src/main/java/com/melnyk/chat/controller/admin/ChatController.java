package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.service.AbstractModelService;
import com.melnyk.chat.service.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/chat")
@AllArgsConstructor
public class ChatController extends AbstractModelController<Chat, Long> {

    private ChatService modelService;

//    public ChatController(AbstractModelService<Chat, Long> modelService) {
//        super(modelService);
//    }

    public List<Chat> readList(User user) {
        return modelService.findAllByUser(user);
    }

    @Override
    public AbstractModelService<Chat, Long> getModelService() {
        return modelService;
    }
}
