package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AlunoDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private int matricula;
    private Turma turma;

    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.matricula = aluno.getMatricula();
        this.turma = aluno.getTurma();
    }

    public static List<AlunoDto> converter (List<Aluno> alunos){
        return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
    }

}
