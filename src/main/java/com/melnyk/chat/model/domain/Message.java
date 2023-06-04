package com.melnyk.chat.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "message")
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
public class Message extends BaseEntity {

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_from_id", nullable = false)
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

}
