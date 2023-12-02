package br.com.projetovai.api.controller;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.Instituicao;
import br.com.projetovai.api.service.InstituicaoService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Instituicao"})
public class InstituicaoController {
    private final InstituicaoService service;

    @PostMapping({"/criar"})
    public ResponseEntity<Instituicao> criarInstituicao(@RequestBody Instituicao instituicao){
        var inserted = service.criarInstituicao(instituicao);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }
    @DeleteMapping({"/delete"})
    public void deleteInstituicao(@RequestBody Instituicao instituicao){
        service.deleteInstituicao(instituicao);
    }

    @GetMapping({"/buscar/{id}"})
    public ResponseEntity<Instituicao> buscarInstiruicaoId(@PathVariable @Validated @NotNull Long id) {
        var getter = service.buscarInstituicaoId(id);
        return ResponseEntity.ok(getter);
    }
    @GetMapping({"/listar"})
    public ResponseEntity<List<Instituicao>> listarInstituicao(){
        var findall = service.listarInstituicao();
        return new ResponseEntity<>(findall, HttpStatus.OK);
    }
}



