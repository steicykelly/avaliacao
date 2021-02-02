package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "tb_curso")
@Data
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private BigInteger idCurso;

    @Column(name = "ds_curso")
    private String nomeCurso;

    @Column(name = "nr_carga_horaria")
    private Integer nrCargaHoraria;
}
