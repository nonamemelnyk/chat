package com.melnyk.chat.model.chat;

import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatNotification {
    private Long id;
    private String text;
    private String messDate;
    private Long userId;
    private String username;
    private Long chatId;
}
