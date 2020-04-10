package com.spring.forum.controller;

import com.spring.forum.model.Topico;
import com.spring.forum.model.builder.TopicoBuilder;
import com.spring.forum.repository.TopicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TopicosController.class)
public class TopicosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TopicoRepository topicoRepository;

    @Test
    void deveRetornarTodosOsTopicos() throws Exception {
        List<Topico> expectedTopicoList = Collections.singletonList(new TopicoBuilder().withTitulo("Meu topico").build());
        when(topicoRepository.findAll()).thenReturn(expectedTopicoList);

        mockMvc.perform(get("/topicos")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$.[0].titulo").value("Meu topico"));
    }

//    @Test
//    void deveRetornarTopicosPorCursoNome() throws Exception {
//        String cursoNome = "Curso teste";
//        List<Topico> expectedTopico = Collections.singletonList(new TopicoBuilder().withCursoNome("Curso teste").build());
//        when(topicoRepository.findByCursoNome(cursoNome)).thenReturn(expectedTopico);
//
//        mockMvc.perform(get("/topicos?curso=" + cursoNome))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value(cursoNome));
//    }

}
