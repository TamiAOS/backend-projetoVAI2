package br.com.projetovai.api.controller;

import br.com.projetovai.api.entity.Aluno;
import br.com.projetovai.api.entity.ONG;
import br.com.projetovai.api.service.ONGService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/ONG"})
public class ONGController {
    private final ONGService service;

    @PostMapping({"/criar"})
    public ResponseEntity<ONG> criarONG(@RequestBody ONG ong){
        var inserted = service.criarONG(ong);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }
    @DeleteMapping({"/delete"})
    public void deleteONG(@RequestBody ONG ong){
        service.deleteONG(ong);
    }

    @GetMapping({"/buscar/{id}"})
    public ResponseEntity<ONG> buscarONGId(@PathVariable @Validated @NotNull Long id)  {
        var getter = service.buscarONG(id);
        return ResponseEntity.ok(getter);
    }
    @GetMapping({"/listar"})
    public ResponseEntity<List<ONG>> listarONG(){
        var findall = service.listarONG();
        return new ResponseEntity<>(findall, HttpStatus.OK);
    }

}
