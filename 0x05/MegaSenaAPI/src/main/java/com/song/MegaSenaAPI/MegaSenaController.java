package com.song.MegaSenaAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

   @GetMapping("/simpleMessageWelcome")
   public String mensagemBoasVindas() {
       String msg = "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
        return msg;
   }


   @GetMapping("/getNumbers")
   public List<Integer> numerosMegaSena() {
         List<Integer> lista = new ArrayList<Integer>();
         Random random = new Random();
         for(int i = 0; i<=6; i++){
            lista.add(random.nextInt(100));
         }
         Collections.sort(lista);
        return lista;
   }
 }
