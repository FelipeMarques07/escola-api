package br.com.insiders.escola.form;

import br.com.insiders.escola.controller.dto.TurmaDto;
import br.com.insiders.escola.controller.form.TurmaForm;
import br.com.insiders.escola.exception.ObjetoNaoEncontrado;
import br.com.insiders.escola.model.Turma;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.time.Year;


@ExtendWith(MockitoExtension.class)
public class TurmaFormTest {

    private TurmaForm turmaForm = TurmaForm.builder().nome("").quantidadeAluno(40).anoLetivo(Year.now()).build();

    @Test
    public void turmaFormTest() {
        Turma turma = turmaForm.converter();
        Assertions.assertEquals(turmaForm.getNome(), turma.getNome());
        Assertions.assertEquals(turmaForm.getQuantidadeAluno(), turma.getQuantidadeAluno());
        Assertions.assertEquals(turmaForm.getAnoLetivo(), turma.getAnoLetivo());
    }

}
