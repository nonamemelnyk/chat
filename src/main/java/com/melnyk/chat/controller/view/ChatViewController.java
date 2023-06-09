package com.melnyk.chat.controller.view;

import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.service.ChatService;
import com.melnyk.chat.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class ChatViewController {

    private ChatService chatService;
    private UserService userService;

    @GetMapping("/chats")
    public String viewChats(Model model, Authentication authentication) {
        User user = userService.findByLogin(authentication.getName()).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("chats", chatService.findAllByUser(user));

//        model.addAttribute("chat_id", 2);
        return "chats";
    }

    @GetMapping("/chats/{chat_id}")
    public String viewChatWindow(@PathVariable("chat_id") String chatId, Model model, Authentication authentication,
                                 HttpServletRequest request) {
        User user = userService.findByLogin(authentication.getName()).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("chat_id", chatId);
//        model.addAttribute("chats", chatService.findAllByUser(user));
        return "appchat";
    }
}
