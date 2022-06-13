package com.impacto.algafoodapi;

import com.impacto.algafoodapi.model.Client;
import com.impacto.algafoodapi.service.ActivationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {

    @Autowired
    private ActivationClientService activationClientService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        var client = new Client("João", "joao@joao.com", "22333334444");
        activationClientService.activate(client);
        return "Hello World";
    }
}
