package br.com.insiders.escola.form;


import br.com.insiders.escola.controller.form.MentorForm;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.MentorRepository;
import br.com.insiders.escola.repository.TurmaRepository;
import br.com.insiders.escola.service.MentorService;
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
public class MentorFormTest {

    private MentorForm mentorForm = MentorForm.builder().nome("Mauricio").sobrenome("Silva").matricula(321123).build();

    @Test
    public void mentorFormTest() {
        
        Mentor mentor = mentorForm.converter();
        Assertions.assertEquals(mentorForm.getNome(), mentor.getNome());
        Assertions.assertEquals(mentorForm.getSobrenome(), mentor.getSobrenome());
        Assertions.assertEquals(mentorForm.getMatricula(), mentor.getMatricula());
    }
}
