package br.com.projetovai.api.controller;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.Projeto;
import br.com.projetovai.api.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/projeto"})
public class ProjetoController {
    private final ProjetoService service;

    @PostMapping({"/criar"})
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto){
        var inserted = service.criarProjeto(projeto);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }
    @DeleteMapping({"/delete"})
    public void deleteProjeto(@RequestBody Projeto projeto){
        service.deleteProjeto(projeto);
    }

    @GetMapping({"/buscar/{id}"})
    public ResponseEntity<Projeto> buscarProjetoId(@PathVariable @Validated @NotNull Long id)  {
        var getter = service.buscarProjetoId(id);
        return ResponseEntity.ok(getter);
    }
    @GetMapping({"/listar"})
    public ResponseEntity<List<Projeto>> listarProjetos(){
        var findall = service.listarProjeto();
        return new ResponseEntity<>(findall, HttpStatus.OK);
    }


}


