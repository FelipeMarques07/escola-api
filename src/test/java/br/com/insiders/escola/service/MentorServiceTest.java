package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.MentorRepository;
import br.com.insiders.escola.repository.TurmaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.module.ModuleDescriptor;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MentorServiceTest {

    @Mock
    MentorRepository mentorRepository;

    @InjectMocks
    MentorService mentorService;

    Mentor mentor = new Mentor(1l, "Mauricio", "Silva", 321123);

    @Test
    public void buscarMentorTest() {


        when(mentorRepository.findById(1)).thenReturn(mentor);
        var getMentorResponse = mentorService.findById(1);
        Assertions.assertEquals(mentor.getId(), getMentorResponse.getId());
        Assertions.assertEquals(mentor.getNome(), getMentorResponse.getNome());
        Assertions.assertEquals(mentor.getSobrenome(), getMentorResponse.getSobrenome());
        Assertions.assertEquals(mentor.getMatricula(), getMentorResponse.getMatricula());


    }

    @Test
    public void listarMentorTest() {

        List<Mentor> mentores = new ArrayList<>();
        mentores.add(mentor);
        when(mentorRepository.findAll()).thenReturn(mentores);
        var getMentoresResponse = mentorService.findAll();
        Assertions.assertEquals(mentores, getMentoresResponse);


    }

    @Test
    public void salvarMentorTest() {

        mentorService.save(mentor);
        verify(mentorRepository).save(Mockito.any());
    }

    @Test
    public void deletarMentorTest() {

        mentorService.delete(1);
        verify(mentorRepository).deleteById(Mockito.any());
    }
}