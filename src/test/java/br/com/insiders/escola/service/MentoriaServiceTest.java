package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MentoriaServiceTest {

    @Mock
    MentorService mentorService;

    @InjectMocks
    MentoriaService mentoriaService;

    @Test
    public void listarMentoriaTest() {

        Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
        Aluno aluno = new Aluno(1l, "Felipe", "Marques", 321123, turma);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        Mentor mentor = new Mentor(1l, "Mauricio", "Silva", 321123, alunos);

        List<Mentor> mentores = new ArrayList<>();
        mentores.add(mentor);

        when(mentorService.findAll()).thenReturn(mentores);
        var getMentoriaResponse = mentoriaService.listarMentoria();
        Assertions.assertEquals(mentores, getMentoriaResponse);

    }
}
