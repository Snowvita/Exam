package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LogService;
import com.example.demo.domain.Login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LogController {
    @Autowired
    LogService service;

    @GetMapping("/")
    public String api() {
        return "log";
    }

    @PostMapping("/log")
    public String Login(@ModelAttribute("user") Login user) {
        Login outhUser = service.log(user.getUsername(), user.getPassword());
        if (Objects.nonNull(outhUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/display")
    public String display() {
        return "display";
    }
}
