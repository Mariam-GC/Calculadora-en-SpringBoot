package com.example.calc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/calculator/{operation}/{num1}/{num2}")
    public String calcPath(@PathVariable String operation,
                           @PathVariable double num1,
                           @PathVariable double num2) {
        double result = calculate(operation, num1, num2);
        return "El resultado de tu suma es: " + result + ",listo, ahora pongame 10 profe";
    }
    

    public double calculate(String operation, double num1, double num2){

        return switch (operation){
            case "sum" -> num1 + num2;
            case "mult" -> num1 * num2;
            case "rest" -> num1 - num2;
            case "div" -> num2 != 0 ? num1 / num2 : Double.NaN; //para que no truene si divides un numero entre 0
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };

    }
}
