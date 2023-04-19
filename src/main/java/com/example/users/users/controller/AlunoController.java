package com.example.users.users.controller;


import com.example.users.users.entities.Aluno;
import com.example.users.users.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Esta classe implementa as operações básicas de CRUD (Create, Read, Update, Delete) para a entidade Aluno, usando o AlunoRepository para manipular os dados do banco de dados.

//        Criando o controlador

//        Por fim, crie a classe AlunoController.java na pasta src/main/java/com/example/demo/controller para definir o controlador REST que lidará com as requisições HTTP para a entidade Aluno:




import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    // retorna todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    // retorna um aluno por id
    @GetMapping("/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    // adiciona um aluno
    @PostMapping
    public Aluno addAluno(@RequestBody Aluno aluno) {
        return alunoService.addAluno(aluno);
    }

    // atualiza um aluno
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(id, aluno);
    }

    // remove um aluno
    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
}
