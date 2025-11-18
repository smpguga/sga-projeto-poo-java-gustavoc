package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // Rota para abrir a página de cursos
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        List<Curso> lista = cursoRepository.findAll();
        model.addAttribute("cursos", lista);
        return "cursos"; // Vai procurar o arquivo cursos.html
    }

    // Rota para salvar um novo curso (recebe do formulário)
    @PostMapping("/cursos/salvar")
    public String salvarCurso(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos";
    }
}