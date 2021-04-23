package br.com.insiders.escola.service;

import br.com.insiders.escola.exception.ObjetoNaoEncontrado;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.repository.MentorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private AlunoService alunoService;

    public List<Mentor> findAll(){ return  mentorRepository.findAll();}

    public Mentor findById(long id){ return mentorRepository.findById(id).orElseThrow(
            () -> new ObjetoNaoEncontrado("Id não encontrado "+ id));}

    public void delete(long id){ mentorRepository.deleteById(id);}

    public void save(Mentor mentor){ mentorRepository.save(mentor);}

}
