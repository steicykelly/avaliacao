package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, BigInteger> {

    List<CursoEntity> findByNomeCurso(String nomeCurso);

}
