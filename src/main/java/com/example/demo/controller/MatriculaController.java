package com.example.demo.model;

import com.example.demo.model.Aluno;
import com.example.demo.model.Disciplina;
import com.example.demo.model.Matricula;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // 1. Mostrar formulário de matrícula e lista de matrículas
    @GetMapping
    public String listar(Model model) {
        List<Matricula> matriculas = matriculaRepository.findAll();
        List<Aluno> alunos = alunoRepository.findAll();
        List<Disciplina> disciplinas = disciplinaRepository.findAll();

        model.addAttribute("matriculas", matriculas);
        model.addAttribute("alunos", alunos);
        model.addAttribute("disciplinas", disciplinas);

        return "matriculas"; // Deve corresponder ao nome do arquivo HTML: matriculas.html
    }

    // 2. Salvar uma nova matrícula
    @PostMapping("/salvar")
    public String salvar(@RequestParam("aluno_id") Long alunoId,
                         @RequestParam("disciplina_id") Long disciplinaId,
                         RedirectAttributes attributes) {

        // Busca as entidades Aluno e Disciplina
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElse(null);

        if (aluno != null && disciplina != null) {
            Matricula novaMatricula = new Matricula(aluno, disciplina);
            matriculaRepository.save(novaMatricula);
            attributes.addFlashAttribute("mensagem", "Matrícula realizada com sucesso!");
        } else {
            attributes.addFlashAttribute("erro", "Aluno ou Disciplina não encontrados.");
        }

        return "redirect:/matriculas";
    }
}