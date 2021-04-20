package br.com.insiders.escola.controller;


import br.com.insiders.escola.controller.dto.AlunoDto;
import br.com.insiders.escola.controller.dto.MentorDto;
import br.com.insiders.escola.controller.dto.MentoriaDto;
import br.com.insiders.escola.controller.form.MentoriaForm;
import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.service.MentorService;
import br.com.insiders.escola.service.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/escola")
public class MentoriaController {

    @Autowired
    private MentoriaService mentoriaService;

    @PostMapping("/mentoria")
    public ResponseEntity<?> salvarMentoria(@RequestBody @Valid MentoriaForm mentoriaForm){
        var mentor = mentoriaForm.converter();
        mentoriaService.saveMentoria(mentor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/mentoria/mentor={idMentor}&aluno={idAluno}")
    public ResponseEntity <?> deletarMentoria(@PathVariable(value = "idMentor") long idMentor, @PathVariable(value = "idAluno") long idAluno){
       mentoriaService.deletar(idMentor,idAluno);
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/mentoria")
    public ResponseEntity <List<MentoriaDto>> listarMentoria(){
        List<Mentor> mentores = mentoriaService.listarMentoria();
        return ResponseEntity.ok(MentoriaDto.converter(mentores));
    }
}
