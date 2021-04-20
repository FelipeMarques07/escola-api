package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.service.TurmaService;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
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
        return new Aluno(nome, sobrenome, matricula, turma);
    }
}
