package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Data
@Table(name="tb_modulo")
public class ModuloEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_modulo")
    private BigInteger idModulo;

    @Column(name="ds_nome")
    private String dsNome;

    @OneToOne
    @JoinColumn(name="id_instrutor")
    private InstrutorEntity instrutor;

}
