package com.melnyk.chat.model.domain;

import com.melnyk.chat.config.enums.UserRoles;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema="public", indexes = {@Index(name = "user_login_index", columnList = "login", unique = true)})
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
public class User extends BaseEntity {

    private String login;
    private String password;
    private String name;

    @Column
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = UserRoles.class, fetch = FetchType.EAGER)
    private Set<UserRoles> roles = new HashSet<>();

}
