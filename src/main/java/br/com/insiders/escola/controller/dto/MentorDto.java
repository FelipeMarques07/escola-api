package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MentorDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private int matricula;


    public MentorDto(Mentor mentor) {
        this.id = mentor.getId();
        this.nome = mentor.getNome();
        this.sobrenome = mentor.getSobrenome();
        this.matricula = mentor.getMatricula();

    }

    public static List<MentorDto> converter (List<Mentor> mentores){
        return mentores.stream().map(MentorDto::new).collect(Collectors.toList());
    }
}
