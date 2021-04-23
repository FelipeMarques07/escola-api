package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.TurmaRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TurmaServiceTest {

    @Mock
    private TurmaRepository turmaRepository;

    @InjectMocks
    private TurmaService turmaService;

    private Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();

    @Test
    public void buscarTurmaTest() {

        when(turmaRepository.findById(1l)).thenReturn(java.util.Optional.ofNullable(turma));
        var getTurmaResponse = turmaService.findById(1);
        Assertions.assertEquals(turma.getId(),getTurmaResponse.getId());
        Assertions.assertEquals(turma.getNome(),getTurmaResponse.getNome());
        Assertions.assertEquals(turma.getQuantidadeAluno(),getTurmaResponse.getQuantidadeAluno());
        Assertions.assertEquals(turma.getAnoLetivo(),getTurmaResponse.getAnoLetivo());

    }
    @Test
    public void listarTurmaTest() {

        List<Turma> turmas = new ArrayList<>();
        turmas.add(turma);
        when(turmaRepository.findAll()).thenReturn(turmas);
        var getTurmasResponse = turmaService.findAll();
        Assertions.assertEquals(turmas, getTurmasResponse);

    }

    @Test
    public void salvarTurmaTest() {
        turmaService.save(turma);
        verify(turmaRepository).save(Mockito.any());
    }

    @Test
    public void deletarTurmaTest() {
        turmaService.delete(1);
        verify(turmaRepository).deleteById(Mockito.any());
    }

}


