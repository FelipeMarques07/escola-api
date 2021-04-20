package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
@ExtendWith(MockitoExtension.class)
public class AlunoDtoTest {

    @Test
    public void alunoDtoTest(){

        Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
        Aluno aluno = Aluno.builder().id(1l).nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();
        AlunoDto alunoDto = new AlunoDto(aluno);
        Assertions.assertEquals(aluno.getId(),alunoDto.getId());
        Assertions.assertEquals(aluno.getNome(),alunoDto.getNome());
        Assertions.assertEquals(aluno.getSobrenome(),alunoDto.getSobrenome());
        Assertions.assertEquals(aluno.getMatricula(),alunoDto.getMatricula());
        Assertions.assertEquals(aluno.getTurma(),alunoDto.getTurma());
    }


}
