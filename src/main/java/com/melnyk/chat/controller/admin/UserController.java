package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.domain.User;
import com.melnyk.chat.service.AbstractModelService;
import com.melnyk.chat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/user")
@AllArgsConstructor
public class UserController extends AbstractModelController<User, Long> {


    private UserService userService;

    @Override
    public AbstractModelService<User, Long> getModelService() {
        return userService;
    }
//    public UserController(AbstractModelService<User, Long> modelService) {
//        super(modelService);
//    }
}
