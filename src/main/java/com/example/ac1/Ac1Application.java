package com.example.ac1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Diretor;
import com.example.ac1.models.Filme;
import com.example.ac1.repositories.DiretorRepository;
import com.example.ac1.repositories.FilmeRepository;

@SpringBootApplication
public class Ac1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);
    }

    @Bean
    CommandLineRunner testeEmConsole(FilmeRepository filmeRepository, DiretorRepository diretorRepository) {
        return args -> {
            Diretor diretor1 = diretorRepository.save(new Diretor(null, "Christopher Nolan"));
            Diretor diretor2 = diretorRepository.save(new Diretor(null, "Greta Gerwig"));

            filmeRepository.save(new Filme(null, "Interestelar", 169, diretor1));
            filmeRepository.save(new Filme(null, "A Origem", 148, diretor1));
            filmeRepository.save(new Filme(null, "Barbie", 114, diretor2));

            System.out.println("[FILMES] Duração maior que 120 minutos:");
            filmeRepository.findByDuracaoGreaterThan(120).forEach(System.out::println);

            System.out.println("[FILMES] Duração menor ou igual a 120 minutos:");
            filmeRepository.findByDuracaoLessThanEqual(120).forEach(System.out::println);

            System.out.println("[FILMES] Título começando com 'A':");
            filmeRepository.findByTituloStartingWith("A").forEach(System.out::println);

            System.out.println("[DIRETORES] Nome começando com 'G':");
            diretorRepository.findByNomeStartingWith("G").forEach(System.out::println);
        };
    }
}
