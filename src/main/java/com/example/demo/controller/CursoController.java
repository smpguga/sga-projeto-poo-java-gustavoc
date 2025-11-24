package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // 1. LISTAR CURSOS
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        List<Curso> lista = cursoRepository.findAll();
        model.addAttribute("cursos", lista);
        return "cursos";
    }

    // 2. SALVAR (Serve para Criar e Atualizar)
    @PostMapping("/cursos/salvar")
    public String salvarCurso(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos";
    }

    // 3. EDITAR (Busca os dados e joga na tela)
    @GetMapping("/cursos/editar/{id}")
    public String editarCurso(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            attributes.addFlashAttribute("erro", "Curso não encontrado.");
            return "redirect:/cursos";
        }

        model.addAttribute("curso", curso);
        return "curso-editar";
    }

    // 4. EXCLUIR
    @GetMapping("/cursos/excluir/{id}")
    public String excluirCurso(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            cursoRepository.deleteById(id);
            attributes.addFlashAttribute("mensagem", "Curso excluído com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Não foi possível excluir. Verifique se há alunos matriculados.");
        }
        return "redirect:/cursos";
    }

}