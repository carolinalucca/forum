package com.spring.forum.controller.form;

import com.spring.forum.model.Curso;
import com.spring.forum.model.Topico;
import com.spring.forum.repository.CursoRepository;

public class TopicoForm {

    private static String titulo;
    private static String mensagem;
    private static String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public static Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
