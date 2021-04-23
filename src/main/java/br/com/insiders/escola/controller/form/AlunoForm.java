package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.service.TurmaService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Min(1)
    private int matricula;


    private Turma turma;


    public Aluno converter(TurmaService turmaService) {
        Turma turma = turmaService.findById(getTurma().getId());
        Aluno aluno = Aluno.builder()
            .nome(nome)
            .sobrenome(sobrenome)
            .matricula(matricula)
            .turma(turma)
            .build();
        return aluno;
    }
}
