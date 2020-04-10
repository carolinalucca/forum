package com.spring.forum.model.builder;

import com.spring.forum.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopicoBuilder {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas = new ArrayList<>();

    public TopicoBuilder withTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public TopicoBuilder withCursoNome(String nomeCurso) {
        curso = new Curso();
        this.curso.setNome(nomeCurso);
        return this;
    }

    public Topico build() {
        Topico topico = new Topico();
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setDataCriacao(dataCriacao);
        topico.setId(id);
        topico.setMensagem(mensagem);
        topico.setRespostas(respostas);
        topico.setStatus(status);
        topico.setTitulo(titulo);
        return topico;
    }
}
