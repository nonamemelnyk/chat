package com.melnyk.chat.module.temp;

import com.melnyk.chat.controller.admin.ChatController;
import com.melnyk.chat.model.domain.Chat;
import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.repository.ChatRepository;
import com.melnyk.chat.service.ChatService;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.Mock;
        import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // register the Mockito extension
public class PricingServiceTest {

    @Mock // // Instruct Mockito to mock this object
    private ChatRepository mockChatRepository;

    @Test
    public void shouldReturnCheapPriceWhenProductIsInStockOfCompetitor() {
        User user = new User();
        List<Chat> emptyList = new ArrayList<>();
        when(mockChatRepository.findAllByUsersContains(user))
                .thenReturn(emptyList);

        ChatService cut = new ChatService(mockChatRepository);

        ChatController ct = new ChatController(cut);
        assertEquals(emptyList,      ct.readList(user));
    }
}
