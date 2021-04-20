package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;

@ExtendWith(MockitoExtension.class)
public class TurmaDtoTest {

    @Test
    public void turmaDtoTest(){
        Turma turma = Turma.builder().id(1l).nome("Turma 2021 1 semestre").quantidadeAluno(40).anoLetivo(Year.now()).build();
        TurmaDto turmaDto = new TurmaDto(turma);
        Assertions.assertEquals(turma.getId(),turmaDto.getId());
        Assertions.assertEquals(turma.getNome(),turmaDto.getNome());
        Assertions.assertEquals(turma.getQuantidadeAluno(),turmaDto.getQuantidadeAluno());
        Assertions.assertEquals(turma.getAnoLetivo(),turmaDto.getAnoLetivo());
    }
}
