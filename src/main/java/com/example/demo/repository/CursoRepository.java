package com.example.demo.repository;

import com.example.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Só isso! O Spring cria os SQLs de salvar, deletar e buscar sozinho.
}