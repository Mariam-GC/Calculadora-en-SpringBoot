package com.example.calc.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CalcController {
    //Mostrar el reultado con PathVariable
    //{operation} al poner las llaves en la palabra operation, nos dice que es un valor cambiante, al igual pasa en {num1} y en {num2}
    @GetMapping("/calculator/{operation}/{num1}/{num2}")
    public String calcPath(@PathVariable String operation,
                           @PathVariable double num1,
                           @PathVariable double num2) {
        double result = calculate(operation, num1, num2);
        return "El resultado de tu suma es: " + result + " usando PathVariable";
    }
    //Mostrar el reultado con RequestParam
    @GetMapping("/calculatorR")
    public String calcQuery(@RequestParam String operation,
                            @RequestParam double num1,
                            @RequestParam double num2) {
        double result = calculate(operation, num1, num2  );
        return "El resultado de tu suma es: " + result + "Usando RequestParam";
    }
    //Mostrar el reultado con RequestBody
    @PostMapping("/calculatorbody")
    public String calcBody(@RequestBody Map<String, Object> payload) {
        String operation = (String) payload.get("operation");
        double num1 = Double.parseDouble(payload.get("num1").toString());
        double num2 = Double.parseDouble(payload.get("num2").toString());

        double result = calculate(operation, num1, num2);
        return "El resultado de tu suma es: " + result + "Usando RequestBody";
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
