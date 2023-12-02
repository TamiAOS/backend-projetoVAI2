package br.com.projetovai.api.service;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.ONG;
import br.com.projetovai.api.entity.Projeto;
import br.com.projetovai.api.exception.AlunoException;
import br.com.projetovai.api.exception.ONGException;
import br.com.projetovai.api.repository.ONGRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ONGService {
    private final ONGRepository repository;

    public ONG criarONG(ONG ong) {
        var inserted = repository.save(ong);
        return inserted;
    }

    public void deleteONG(ONG ong) {
        repository.delete(ong);
    }

    public ONG buscarONG(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ONGException("ONG não encontrada"));
    }
    public List<ONG> listarONG() {
        return repository.findAll();
    }

}

