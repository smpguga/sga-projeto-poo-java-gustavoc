package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // 1. LISTAR
    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll()); // Para o formulário de cadastro
        return "alunos";
    }

    // 2. SALVAR (Novo e Edição)
    @PostMapping("/alunos/salvar")
    public String salvarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos";
    }

    // 3. EDITAR (NOVO)
    @GetMapping("/alunos/editar/{id}")
    public String editarAluno(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);

        if (aluno == null) {
            attributes.addFlashAttribute("erro", "Aluno não encontrado.");
            return "redirect:/alunos";
        }

        model.addAttribute("aluno", aluno);
        model.addAttribute("cursos", cursoRepository.findAll()); // Precisamos da lista para o <select>
        return "aluno-editar"; // Vamos criar este arquivo no Passo 2
    }

    // 4. EXCLUIR (NOVO)
    @GetMapping("/alunos/excluir/{id}")
    public String excluirAluno(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            alunoRepository.deleteById(id);
            attributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Não é possível excluir: Aluno possui matrículas ou registros vinculados.");
        }
        return "redirect:/alunos";
    }
}