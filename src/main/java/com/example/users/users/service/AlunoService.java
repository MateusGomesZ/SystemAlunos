package com.example.users.users.service;
import com.example.users.users.entities.Aluno;
import com.example.users.users.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Esta anotação indica que essa classe é um serviço Spring que implementa a lógica do negócio.
public class AlunoService {
    @Autowired // Esta anotação indica que o Spring deve injetar o AlunoRepository automaticamente

    private AlunoRepository alunoRepository;

    // retorna todos os alunos
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    // retorna um aluno por id
    public Optional<Aluno> getAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    // adiciona um aluno
    public Aluno addAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // atualiza um aluno
    public Aluno updateAluno(Long id, Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            aluno.setId(id);
            return alunoRepository.save(aluno);
        } else {
            return null;
        }
    }

    // remove um aluno
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}