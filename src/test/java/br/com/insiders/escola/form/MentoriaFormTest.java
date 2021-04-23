package br.com.insiders.escola.form;

import br.com.insiders.escola.controller.form.MentorForm;
import br.com.insiders.escola.controller.form.MentoriaForm;
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
public class MentoriaFormTest {

    private Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
    private Aluno aluno = Aluno.builder().id(1l).nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();


    @Test
    public void mentoriaFormTest() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        MentoriaForm mentoriaForm= MentoriaForm.builder().id(1l).alunos(alunos).build();
        Mentor mentorTmp = mentoriaForm.converter();
        Assertions.assertEquals(mentoriaForm.getId(), mentorTmp.getId());
        Assertions.assertEquals(mentoriaForm.getAlunos(), mentorTmp.getAlunos());

    }
}
