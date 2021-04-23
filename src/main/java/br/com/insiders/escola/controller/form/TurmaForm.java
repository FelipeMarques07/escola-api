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
import java.time.Year;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaForm {

    @NotBlank
    private String nome;

    @Min(1)
    private int quantidadeAluno;

    private Year anoLetivo;


    public Turma converter() {
        Turma turma = Turma.builder()
            .nome(nome)
            .anoLetivo(anoLetivo)
            .quantidadeAluno(quantidadeAluno)
            .build();
        return turma;
    }



}
