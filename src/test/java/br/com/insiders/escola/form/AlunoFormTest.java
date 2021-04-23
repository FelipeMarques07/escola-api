package br.com.insiders.escola.form;

import br.com.insiders.escola.controller.form.AlunoForm;
import br.com.insiders.escola.controller.form.TurmaForm;
import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.TurmaRepository;
import br.com.insiders.escola.service.TurmaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlunoFormTest {

    @Mock
    private TurmaRepository turmaRepository;

    @InjectMocks
    private TurmaService turmaService;

    private Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
    private AlunoForm alunoForm = AlunoForm.builder().nome("Felipe").sobrenome("Marques").matricula(321123).turma(turma).build();

    @Test
    public void alunoFormTest() {

        when(turmaService.findById(1)).thenReturn(turma);
        Aluno aluno = alunoForm.converter(turmaService);
        Assertions.assertEquals(alunoForm.getNome(), aluno.getNome());
        Assertions.assertEquals(alunoForm.getSobrenome(), aluno.getSobrenome());
        Assertions.assertEquals(alunoForm.getMatricula(), aluno.getMatricula());
        Assertions.assertEquals(alunoForm.getTurma(), aluno.getTurma());
    }

    @Test
    public void alunoFormErrorTest() {

    }
}
