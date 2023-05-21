package com.partior.starwars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String index() {
        return "A backend service to provide information about Star Wars";
    }

}
