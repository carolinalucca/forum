package com.spring.forum.controller;

import com.spring.forum.controller.dto.TopicoDto;
import com.spring.forum.controller.form.TopicoForm;
import com.spring.forum.model.Topico;
import com.spring.forum.repository.CursoRepository;
import com.spring.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String curso) {
        if (curso == null) {
            return TopicoDto.converter(topicoRepository.findAll());
        } else {
            return TopicoDto.converter(topicoRepository.findByCursoNome(curso));
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
        Topico topico = TopicoForm.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}
