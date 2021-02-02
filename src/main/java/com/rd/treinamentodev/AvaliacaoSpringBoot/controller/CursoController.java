package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("/curso")
    public ResponseEntity cadastrarCurso(@RequestBody CursoDTO curso){

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.cadastrarCurso(curso));

    }

    @GetMapping("/curso/{id}")
    public ResponseEntity getCurso(@PathVariable("id") BigInteger id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.getCurso(id));
    }

}
