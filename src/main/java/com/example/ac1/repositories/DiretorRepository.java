package com.example.ac1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac1.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    List<Diretor> findByNomeStartingWith(String nome);
}