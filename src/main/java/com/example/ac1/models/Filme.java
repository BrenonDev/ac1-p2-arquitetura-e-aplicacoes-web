package com.example.ac1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "filmes")
@Getter
@Setter
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Integer duracao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "diretor_id", nullable = false)
    private Diretor diretor;

    public Filme() {
    }

    public Filme(Long id, String titulo, Integer duracao, Diretor diretor) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme{id=" + id + ", titulo='" + titulo + "', duracao=" + duracao + "}";
    }
}