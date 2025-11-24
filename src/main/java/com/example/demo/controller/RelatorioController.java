package com.example.demo.controller;

import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/relatorios")
    public String exibirRelatorios(Model model) {
        // Envia as listas para a tela
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("matriculas", matriculaRepository.findAll());
        model.addAttribute("totalAlunos", alunoRepository.count()); // Contagem total

        return "relatorios";
    }
}