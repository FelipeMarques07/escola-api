package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MentoriaDtoTest {

    @Test
    public void mentoriaDtoTest() {
        Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
        Aluno aluno = Aluno.builder().id(1l).nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        Mentor mentor = Mentor.builder().id(1l).nome("Mauricio").sobrenome("Silva").matricula(321123).build();
        MentoriaDto mentorDto = new MentoriaDto(mentor);
        Assertions.assertEquals(1, mentorDto.getId());
        Assertions.assertEquals(mentor.getNome(), mentorDto.getNome());
        Assertions.assertEquals(mentor.getSobrenome(), mentorDto.getSobrenome());
        Assertions.assertEquals(mentor.getMatricula(), mentorDto.getMatricula());
        Assertions.assertEquals(mentor.getAlunos(), mentorDto.getAlunos());

    }
}
