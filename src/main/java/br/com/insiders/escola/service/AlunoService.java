package br.com.insiders.escola.service;

import br.com.insiders.escola.exception.ObjetoNaoEncontrado;
import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public List<Aluno> findAll(){ return  alunoRepository.findAll();}

    public Aluno findById(long id){ return alunoRepository.findById(id).orElseThrow(
            () -> new ObjetoNaoEncontrado("Id não encontrado "+ id));}

    public void delete(long id){ alunoRepository.deleteById(id);}

    public void save(Aluno aluno){ alunoRepository.save(aluno);}

}
