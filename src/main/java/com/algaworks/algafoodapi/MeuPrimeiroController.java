package com.algaworks.algafoodapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {


    // Para adicionar DevTools ao IntelliJ IDE
    // - Adicionar ao pom a dependência;
    // - File > Settings > Build, Execution, Deployment > Compiler, ativar a opção "Build project automatically";
    // - File > Settings > Advanced Settings > ativar a opção "Allow auto-make to start...".
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello!!!";
    }
}
