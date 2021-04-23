package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.MentorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MentoriaServiceTest {



    @Mock
    private MentorService mentorService;

    @Mock
    private MentorRepository mentorRepository;

    @InjectMocks
    private MentoriaService mentoriaService;

    @InjectMocks
    private MentorService mentorServiceTmp;

    private Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
    private Aluno aluno1 = Aluno.builder().id(1l).nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();
    private Aluno aluno2 = Aluno.builder().id(2l).nome("José").sobrenome("Silva").matricula(321122).turma(turma).build();
    private Mentor mentor = Mentor.builder().id(1l).nome("Mauricio").sobrenome("Silva").matricula(321123).build();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Mentor> mentores = new ArrayList<>();

    @Test
    public void listarMentoriaTest() {

        alunos.add(aluno1);
        mentor.setAlunos(alunos);
        mentores.add(mentor);
        when(mentorService.findAll()).thenReturn(mentores);
        var getMentoriaResponse = mentoriaService.listarMentoria();
        Assertions.assertEquals(mentores, getMentoriaResponse);

    }
    @Test
    public void saveMentoriaTest() {

        alunos.add(aluno1);
        mentor.setAlunos(alunos);
        when(mentorRepository.findById(1l)).thenReturn(java.util.Optional.ofNullable(mentor));
        var mentorTmp = mentorServiceTmp.findById(1);
        mentorTmp = mentoriaService.verificarQuantidadeAlunosMentorTurma(aluno2, mentor);
        mentorServiceTmp.save(mentor);
        verify(mentorRepository).save(any());



    }
    @Test
    public void verificarQuantidadeAlunosMentorTurmaTest() {
        alunos.add(aluno1);
        mentor.setAlunos(alunos);
        Mentor mentorTmp  = mentoriaService.verificarQuantidadeAlunosMentorTurma(aluno2, mentor);
        Assertions.assertEquals(mentor, mentorTmp);
    }
}
