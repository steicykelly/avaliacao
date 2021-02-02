package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class TurmaDTO {

    private CursoDTO curso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dtInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dtFim;

    private List<InstrutorDTO> instrutores;

    private List<AlunoDTO> alunos;

}
