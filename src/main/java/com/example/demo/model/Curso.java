package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer carga_horaria;
    private String descricao;

    // --- AQUI ESTAVA FALTANDO: O relacionamento com Alunos ---
    // mappedBy = "curso" significa que quem manda na relação é o campo 'curso' lá na classe Aluno
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getCarga_horaria() { return carga_horaria; }
    public void setCarga_horaria(Integer carga_horaria) { this.carga_horaria = carga_horaria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // --- Getter e Setter da Lista de Alunos (Essenciais para o Relatório) ---
    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
}