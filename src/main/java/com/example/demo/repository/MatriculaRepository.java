package com.example.demo.repository;

import com.example.demo.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // Método para listartodas as matrículas de um aluno (útil para relatórios)
    List<Matricula> findByAlunoId(Long alunoId);
}
