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
    private MentorService mentorService;

    @InjectMocks
    private MentoriaService mentoriaService;

    private Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
    private Aluno aluno = Aluno.builder().id(1l).nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();
    private Mentor mentor = Mentor.builder().id(1l).nome("Mauricio").sobrenome("Silva").matricula(321123).build();

    @Test
    public void listarMentoriaTest() {

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        List<Mentor> mentores = new ArrayList<>();
        mentores.add(mentor);

        when(mentorService.findAll()).thenReturn(mentores);
        var getMentoriaResponse = mentoriaService.listarMentoria();
        Assertions.assertEquals(mentores, getMentoriaResponse);

    }
}
