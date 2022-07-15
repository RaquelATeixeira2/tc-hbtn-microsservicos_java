package com.example.calculator.controller;

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.Calculator;


@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
    
    @Autowired
    Calculator calculator;

    @GetMapping("/welcome")
    public String messageWelcome() {
       return "Bem vindo a calculadora API!!";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return String.format("%.2f + %.2f = %.2f", n1, n2,calculator.sum(n1, n2));
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
       return String.format("%.2f - %.2f = %.2f", n1, n2, calculator.sub(n1,n2));
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return String.format("%.2f / %.2f = %.2f", n1, n2, calculator.divide(n1, n2));
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        return String.format("O fatorial do número %d é o número %d", factorial, calculator.factorial(factorial));
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) throws ParseException {
            return String.format("A diferença entre as datas é de %d dias", calculator.calculeDayBetweenDate(localDate1, localDate2));
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        return String.format("O binário de %d é %d", n1, calculator.integerToBinary(n1));
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        return String.format("O hexadecimal de %d é %s", n1, calculator.integerToHexadecimal(n1));
    }
}
