package com.melnyk.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class CheckAccessController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<Boolean> health() {
        return ResponseEntity.ok(true);
    }
}
