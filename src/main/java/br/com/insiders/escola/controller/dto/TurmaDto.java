package br.com.insiders.escola.controller.dto;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TurmaDto {

    private Long id;
    private String nome;
    private int quantidadeAluno;
    private Year anoLetivo;

    public TurmaDto(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.quantidadeAluno = turma.getQuantidadeAluno();
        this.anoLetivo = turma.getAnoLetivo();
    }

    public static List<TurmaDto> converter (List<Turma> turmas){
        return turmas.stream().map(TurmaDto::new).collect(Collectors.toList());
    }

}
