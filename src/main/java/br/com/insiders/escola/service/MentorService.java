package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.AlunoRepository;
import br.com.insiders.escola.repository.MentorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private AlunoService alunoService;

    public List<Mentor> findAll(){ return  mentorRepository.findAll();}

    public Mentor findById(long id){ return mentorRepository.findById(id);}

    public void delete(long id){ mentorRepository.deleteById(id);}

    public void save(Mentor mentor){ mentorRepository.save(mentor);}

}
