package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MentorDtoTest {

    @Test
    public void mentorDtoTest() {

        Mentor mentor = new Mentor(1l, "Mauricio", "Silva", 321123);
        MentorDto mentorDto = new MentorDto(mentor);
        Assertions.assertEquals(1, mentorDto.getId());
        Assertions.assertEquals(mentor.getNome(), mentorDto.getNome());
        Assertions.assertEquals(mentor.getSobrenome(), mentorDto.getSobrenome());
        Assertions.assertEquals(mentor.getMatricula(), mentorDto.getMatricula());

    }
}
