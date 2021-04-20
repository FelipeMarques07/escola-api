package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.AlunoRepository;
import br.com.insiders.escola.repository.TurmaRepository;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    AlunoRepository alunoRepository;

    @InjectMocks
    AlunoService alunoService;

    Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
    Aluno aluno = new Aluno(1l,"Felipe","Marques",321123,turma);

    @Test
    public void buscarAlunoTest(){

        when(alunoRepository.findById(1)).thenReturn(aluno);
        var getAlunoResponse = alunoService.findById(1);
        Assertions.assertEquals(aluno.getId(),getAlunoResponse.getId());
        Assertions.assertEquals(aluno.getNome(),getAlunoResponse.getNome());
        Assertions.assertEquals(aluno.getSobrenome(),getAlunoResponse.getSobrenome());
        Assertions.assertEquals(aluno.getMatricula(),getAlunoResponse.getMatricula());
        Assertions.assertEquals(aluno.getTurma(),getAlunoResponse.getTurma());

    }
    @Test
    public void listarAlunoTest(){

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        when(alunoRepository.findAll()).thenReturn(alunos);
        var getAlunosResponse = alunoService.findAll();
        Assertions.assertEquals(alunos, getAlunosResponse);

    }

    @Test
    public void salvarAlunoTest() {
        alunoService.save(aluno);
        verify(alunoRepository).save(Mockito.any());
    }

    @Test
    public void deletarAlunoTest() {
        alunoService.delete(1);
        verify(alunoRepository).deleteById(Mockito.any());
    }
}