package com.melnyk.chat.repository;

import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByUsersContains(User user);
}
