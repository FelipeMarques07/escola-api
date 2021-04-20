package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.controller.dto.AlunoDto;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class MentorForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Min(1)
    private int matricula;


    public Mentor converter() {
        return new Mentor(nome,sobrenome,matricula);
    }
}
