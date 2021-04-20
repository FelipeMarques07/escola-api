package br.com.insiders.escola.service;

import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> findAll(){
        return  turmaRepository.findAll();
    }

    public Turma findById(long id){
        return turmaRepository.findById(id);
    }

    public void delete(long id){
       turmaRepository.deleteById(id);
    }

    public void save(Turma turma){ turmaRepository.save(turma);}
}
