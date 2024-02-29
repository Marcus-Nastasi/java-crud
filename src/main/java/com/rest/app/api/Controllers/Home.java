package com.rest.app.api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping(value = "/")
    public String home() {
      return "Olá novamente!";
    };
}


