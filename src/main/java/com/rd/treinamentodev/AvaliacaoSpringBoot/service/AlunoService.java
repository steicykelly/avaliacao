package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public ResponseEntity gravar(AlunoDTO alunoDTO){
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());

        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro
        String cpf= alunoDTO.getCpf();

        consultarPorCpf(cpf);
        List<AlunoDTO> alunos = new ArrayList<>();
        for(){

        }

        entity = alunoRepository.save(entity);

        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }

    public List<AlunoDTO> consultarPorCpf(String cpf){
        List<AlunoEntity> alunos = alunoRepository.findByCpf(cpf);

        List<AlunoDTO> alunosDTO = new ArrayList<>();

        List<AlunoEntity> alunosEntity = new ArrayList<>();
        for(AlunoEntity alunoEntity : alunosEntity){
            AlunoDTO alunoDTO = new AlunoDTO();
            alunoDTO.setNome(alunoEntity.getNomeAluno());
            alunoDTO.setCpf(alunoEntity.getCpf());

            alunosDTO.add(alunoDTO);
        }

        return alunosDTO;

    }

}
