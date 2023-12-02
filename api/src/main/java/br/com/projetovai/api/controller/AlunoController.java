package br.com.projetovai.api.controller;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.service.AlunoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/aluno"})
public class AlunoController {
    private final AlunoService service;

    @PostMapping({"/criar"})
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno){
        var inserted = service.criarAluno(aluno);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }
    @DeleteMapping({"/delete"})
    public void deleteAluno(@RequestBody Aluno aluno){
         service.deleteAluno(aluno);
    }
    @GetMapping({"/buscar/{id}"})
    public ResponseEntity<Aluno> buscarAlunoId(@PathVariable @Validated @NotNull Long id) {
        var getter = service.buscarAlunoId(id);
        return ResponseEntity.ok(getter);
    }
    @GetMapping({"/listar"})
    public ResponseEntity<List<Aluno>> listarAluno(){
        var findall = service.listarAlunos();
        return new ResponseEntity<>(findall, HttpStatus.OK);
    }
}
