package com.example.fristspringboot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    public Map getVersion(){
        Map map = new HashMap<String,String>();
        map.put("app-version",appVersion);
        return map;
    }
}
