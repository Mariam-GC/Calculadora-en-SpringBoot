package com.example.calc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/HolaWey")
    public String Hola(){
        return "HolaWey";
    }
}
