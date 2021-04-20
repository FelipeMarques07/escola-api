package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MentoriaDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private int matricula;
    private List<Aluno> alunos;


    public MentoriaDto(Mentor mentor) {
        this.id = mentor.getId();
        this.nome = mentor.getNome();
        this.sobrenome = mentor.getSobrenome();
        this.matricula = mentor.getMatricula();
        this.alunos = mentor.getAlunos();
    }


    public static List<MentoriaDto> converter (List<Mentor> mentores){
        return mentores.stream().map(MentoriaDto::new).collect(Collectors.toList());
    }
}
