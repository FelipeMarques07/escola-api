package br.com.insiders.escola.controller.form;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MentoriaForm {


    private Long id;


    private List<Aluno> alunos;


    public Mentor converter() {
        return new Mentor(id,alunos);
    }

}
