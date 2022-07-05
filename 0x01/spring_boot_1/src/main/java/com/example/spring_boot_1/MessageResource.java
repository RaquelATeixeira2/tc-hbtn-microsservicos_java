package com.example.spring_boot_1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        String msg = "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
        return msg;

    }

    @GetMapping("/login")
    public String login(@RequestParam String login, String senha) {
        if(login.isEmpty() || login.isBlank() || senha.isEmpty() || senha.isBlank()){
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        }

        if(login.length() > 15 || senha.length() > 15){
            return "USUÁRIO E SENHA INVÁLIDOS";
        }
       
        return "LOGIN EFETUADO COM SUCESSO !!";

    }

    
}
