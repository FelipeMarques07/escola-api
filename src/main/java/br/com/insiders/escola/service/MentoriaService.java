package br.com.insiders.escola.service;


import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentoriaService {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private AlunoService alunoService;

    public void saveMentoria(Mentor mentor){
        Mentor mentorTmp = mentorService.findById(mentor.getId());
        mentor.getAlunos().forEach(aluno -> verificarQuantidadeAlunosMentorTurma(alunoService.findById(aluno.getId()),mentorTmp));
        mentorService.save(mentorTmp);
    }

    public Mentor verificarQuantidadeAlunosMentorTurma(Aluno alunoTmp, Mentor mentor){
        var alunoPorTurma =mentor.getAlunos().stream()
                .filter(aluno -> aluno.getTurma().getId() == alunoTmp.getTurma().getId())
                .count();

        if(alunoPorTurma >= 3){
            throw new RuntimeException("Não foi possivel, pois esse mentor já possui 3 alunos dessa turma");
        }
        mentor.getAlunos().add(alunoTmp);
        return mentor;
    }

    public void deletar(long idMentor, long idAluno){
        Mentor mentorTmp = mentorService.findById(idMentor);
        mentorTmp.getAlunos().removeIf(aluno -> aluno.getId() == idAluno);
        mentorService.save(mentorTmp);

    }
    public List<Mentor> listarMentoria(){
        var mentores = mentorService.findAll();
        mentores.removeIf(mentor -> mentor.getAlunos().isEmpty());
        return mentores;
    }
}
