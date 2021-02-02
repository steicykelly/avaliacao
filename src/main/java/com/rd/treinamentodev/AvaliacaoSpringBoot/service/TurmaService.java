package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        for(TurmaEntity turmaEntity : listEntity){
            TurmaDTO turmaDTO = new TurmaDTO();

            turmaDTO.setDtInicio(turmaEntity.getDtInicio());
            turmaDTO.setDtFim(turmaEntity.getDtFinal());

            //Curso
//            CursoDTO cursoDTO = turmaDTO.getCurso();
//            turmaDTO.setCurso(turmaEntity.getCurso());

            //Instrutores
            List<InstrutorEntity> instrutoresEntity = turmaEntity.getInstrutores();

            List<InstrutorDTO> intrutoresDTO = new ArrayList<>();

            for(InstrutorEntity instrutorEntity : instrutoresEntity){
                InstrutorDTO instrutorDTO = new InstrutorDTO();
                instrutorDTO.setNome(instrutorEntity.getNomeInstrutor());
                instrutorDTO.setValorHora(instrutorEntity.getValorHora());

                intrutoresDTO.add(instrutorDTO);
            }

            turmaDTO.setInstrutores(intrutoresDTO);

            //Alunos
            List<AlunoEntity> alunosEntity = turmaEntity.getAlunos();

            List<AlunoDTO> alunosDTO = new ArrayList<>();

            for(AlunoEntity alunoEntity : alunosEntity){
                AlunoDTO alunoDTO = new AlunoDTO();
                alunoDTO.setNome(alunoEntity.getNomeAluno());
                alunoDTO.setCpf(alunoEntity.getCpf());

                alunosDTO.add(alunoDTO);
            }

            turmaDTO.setAlunos(alunosDTO);

            listDTO.add(turmaDTO);
        }

        return listDTO;
    }

}
