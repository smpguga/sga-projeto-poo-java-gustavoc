package com.example.demo.controller;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/disciplinas")
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll()); // Para o select box
        return "disciplinas";
    }

    @PostMapping("/disciplinas/salvar")
    public String salvarDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplinas";
    }
}
