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
        Aluno aluno = new Aluno(1l,"Felipe","Marques",321123,turma);
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        Mentor mentor = new Mentor(1l, "Mauricio", "Silva", 321123,alunos);
        MentoriaDto mentorDto = new MentoriaDto(mentor);
        Assertions.assertEquals(1, mentorDto.getId());
        Assertions.assertEquals(mentor.getNome(), mentorDto.getNome());
        Assertions.assertEquals(mentor.getSobrenome(), mentorDto.getSobrenome());
        Assertions.assertEquals(mentor.getMatricula(), mentorDto.getMatricula());
        Assertions.assertEquals(mentor.getAlunos(), mentorDto.getAlunos());

    }
}
