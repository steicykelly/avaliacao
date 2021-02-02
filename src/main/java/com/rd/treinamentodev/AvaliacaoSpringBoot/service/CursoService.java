package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public String cadastrarCurso(CursoDTO curso){

        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setNomeCurso(curso.getNome());
        cursoEntity.setNrCargaHoraria(curso.getCargaHoraria());

        cursoRepository.save(cursoEntity);

        return "Cadastro do curso realizado com sucesso!";

    }

    public CursoEntity getCurso(BigInteger id){

        CursoEntity cursoEntity= cursoRepository.findById(id).get();
        return cursoEntity;

    }

}
