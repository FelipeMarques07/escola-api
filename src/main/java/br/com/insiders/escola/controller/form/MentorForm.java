package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.controller.dto.AlunoDto;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Min(1)
    private int matricula;


    public Mentor converter() {
        Mentor mentor = Mentor.builder()
            .nome(nome)
            .sobrenome(sobrenome)
            .matricula(matricula)
            .build();
        return mentor;
    }
}
