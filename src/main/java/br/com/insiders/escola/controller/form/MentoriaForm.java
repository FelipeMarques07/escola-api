package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentoriaForm {


    private Long id;

    private List<Aluno> alunos;


    public Mentor converter() {
        Mentor mentor = Mentor.builder()
            .id(id)
            .alunos(alunos)
            .build();
        return mentor;
    }

}
