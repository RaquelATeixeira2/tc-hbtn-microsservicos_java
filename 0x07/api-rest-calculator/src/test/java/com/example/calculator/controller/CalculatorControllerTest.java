package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers?number1=1&number2=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("2.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception{
        RequestBuilder request = get("/calculator/subNumbers?number1=3&number2=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("2.0", result.getResponse().getContentAsString());
    }
    @Test
    void divideNumbers() throws Exception{
        RequestBuilder request = get("/calculator/divideNumbers?number1=3&number2=2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("1.5", result.getResponse().getContentAsString());
    }
    @Test
    void factorial() throws Exception{
        RequestBuilder request = get("/calculator/factorial?factorial=2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("2", result.getResponse().getContentAsString());
    }
    @Test
    void calculeDayBetweenDate() throws Exception{
        RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2020-03-15&localDate2=2020-03-19");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("4", result.getResponse().getContentAsString());
    }
    @Test
    void integerToBinary() throws Exception{
        RequestBuilder request = get("/calculator/integerToBinary?number1=2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10", result.getResponse().getContentAsString());
    }
    @Test
    void integerToHexadecimal() throws Exception{
        RequestBuilder request = get("/calculator/integerToHexadecimal?number1=10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("a", result.getResponse().getContentAsString());
    }
}