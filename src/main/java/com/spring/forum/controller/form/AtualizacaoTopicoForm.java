package com.spring.forum.controller.form;

import com.spring.forum.model.Topico;
import com.spring.forum.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull @NotEmpty
    private String mensagem;

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

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topico.get().setTitulo(this.titulo);
            topico.get().setMensagem(this.mensagem);
            return topico.get();
        }

        return null;
    }
}
