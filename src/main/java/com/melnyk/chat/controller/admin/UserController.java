package com.melnyk.chat.controller.admin;

import com.melnyk.chat.model.User;
import com.melnyk.chat.service.AbstractModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController extends AbstractModelController<User, Long> {

    public UserController(AbstractModelService<User, Long> modelService) {
        super(modelService);
    }
}
