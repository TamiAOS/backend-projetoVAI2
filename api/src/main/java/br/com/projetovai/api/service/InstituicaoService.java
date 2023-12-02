package br.com.projetovai.api.service;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.Instituicao;
import br.com.projetovai.api.entity.ONG;
import br.com.projetovai.api.entity.Projeto;
import br.com.projetovai.api.exception.AlunoException;
import br.com.projetovai.api.exception.InstituicaoException;
import br.com.projetovai.api.repository.InstituicaoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituicaoService {
    private final InstituicaoRepository repository;

    public Instituicao criarInstituicao(Instituicao instituicao) {
        var inserted = repository.save(instituicao);
        return inserted;
    }

    public void deleteInstituicao(Instituicao instituicao) {
        repository.delete(instituicao);
    }

    public Instituicao buscarInstituicaoId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InstituicaoException("Instituição não encontrado"));
    }
    public List<Instituicao> listarInstituicao() {
        return repository.findAll();
    }
}
