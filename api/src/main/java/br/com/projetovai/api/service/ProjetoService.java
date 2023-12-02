package br.com.projetovai.api.service;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.Projeto;
import br.com.projetovai.api.exception.AlunoException;
import br.com.projetovai.api.exception.ProjetoException;
import br.com.projetovai.api.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {
    private final ProjetoRepository repository;

    public Projeto criarProjeto(Projeto projeto) {
        var inserted = repository.save(projeto);
        return inserted;
    }

    public void deleteProjeto(Projeto projeto) {
        repository.delete(projeto);
    }

    public Projeto buscarProjetoId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjetoException("Projeto não encontrado"));
    }
    public List<Projeto> listarProjeto() {
        return repository.findAll();
    }

}
