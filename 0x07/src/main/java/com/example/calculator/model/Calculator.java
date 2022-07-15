package com.example.calculator.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.IntStream;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        if(number1 == null || number2 == null){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios");
        }
          
      return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if(number1 == null || number2 == null){
           throw new NullPointerException("Número 1 e número 2 são obrigatórios");
       }
       return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        if(number1 == null || number2 == null){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios");
        } 
        if(number1 == 0 || number2 == 0){
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
      }

    public Integer factorial(Integer factorial) {
        if (factorial == null){
            throw new NullPointerException("Número é obrigatório.");
        }

        return IntStream.rangeClosed(2, factorial).reduce(1, (x, y) -> x * y);

    }

        // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
         if(integer == null){
            throw new NullPointerException("Número é obrigatório.");
         }

         return Integer.parseInt(Integer.toBinaryString(integer));
    }   

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        if(integer == null){
            throw new NullPointerException("Número é obrigatório.");
        }

        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14 
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) throws ParseException {
        if (date1 == null || date2 == null)
            throw new NullPointerException("As datas sao obrigatorias");

        String dateStart = date1.getYear() + "/" + date1.getMonthValue() + "/" + date1.getDayOfMonth();
        String dateStop = date2.getYear() + "/" + date2.getMonthValue() + "/" + date2.getDayOfMonth();

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Date d1 = null;
        Date d2 = null;

        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);

        long diff = d2.getTime() - d1.getTime();


        return (int) (diff / (24 * 60 * 60 * 1000));
    }

}