package com.spring.forum.controller;

import com.spring.forum.model.Curso;
import com.spring.forum.model.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<Topico> lista(String curso) {

        Topico topico = new Topico("teste", "teste", new Curso("teste", "teste"));

        return Arrays.asList(topico, topico, topico);
    }
}
