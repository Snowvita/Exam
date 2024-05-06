package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login;
import com.example.demo.repository.LogRepo;

@Service
public class LogService {
    @Autowired
    LogRepo rep;

    public Login log(String Username, String Password) {
        return rep.findByUsernameAndPassword(Username, Password);
    }
}
