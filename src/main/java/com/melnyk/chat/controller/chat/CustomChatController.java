package com.melnyk.chat.controller.chat;

import com.melnyk.chat.model.chat.ChatNotification;
import com.melnyk.chat.model.chat.Greeting;
import com.melnyk.chat.model.chat.HelloMessage;
import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.Message;
import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.service.ChatService;
import com.melnyk.chat.service.MessageService;
import com.melnyk.chat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.time.Instant;
import java.util.Date;


@Controller
@AllArgsConstructor
public class CustomChatController {

    private SimpMessagingTemplate messagingTemplate;
    private MessageService messageService;
    private ChatService chatService;
    private UserService userService;


    @MessageMapping("/chat/{chatId}")
    public void processMessage(@DestinationVariable String chatId, HelloMessage text, Authentication authentication) {
        User user = userService.findByLogin(authentication.getName()).orElse(null);
        Chat chat = chatService.findById(Long.parseLong(chatId)).orElse(null);

        Message message = new Message();
        message.setDate(Date.from(Instant.now()));
        message.setUserFrom(user);
        message.setText(text.getName());
        message.setChat(chat);
        var savedMess = messageService.save(message);
        messagingTemplate.convertAndSend(
                "/topic/chat/" + chatId + "/queue/messages",
                new ChatNotification(savedMess.getId(), savedMess.getText(), savedMess.getDate().toString(),
                        savedMess.getUserFrom().getId(), savedMess.getUserFrom().getName(), savedMess.getChat().getId()));
    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
