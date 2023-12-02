package br.com.projetovai.api.service;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.exception.AlunoException;
import br.com.projetovai.api.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository repository;
    public Aluno criarAluno(Aluno aluno) {
        var inserted = repository.save(aluno);
        return inserted;
    }
    public  void deleteAluno(Aluno aluno){
         repository.delete(aluno);
    }
    public Aluno buscarAlunoId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AlunoException("Aluno não encontrado"));
    }

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }
}
