package br.com.insiders.escola.controller;

import br.com.insiders.escola.controller.dto.MentorDto;
import br.com.insiders.escola.controller.dto.TurmaDto;
import br.com.insiders.escola.controller.form.MentorForm;
import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.ws.rs.PUT;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/escola")
public class MentorController {

    @Autowired
    private MentorService mentorService;


    @GetMapping("/mentores")
    public ResponseEntity <List<MentorDto>> listarMentor (){
        List<Mentor> mentores = mentorService.findAll();
        return ResponseEntity.ok(MentorDto.converter(mentores));
    }

    @GetMapping("/mentores/{id}")
    public ResponseEntity <MentorDto> buscarMentor(@PathVariable(value = "id") long id){
        Mentor mentor = mentorService.findById(id);
        return ResponseEntity.ok(new MentorDto(mentor));
    }

    @DeleteMapping("/mentores/{id}")
    public ResponseEntity <?> deletarMentor(@PathVariable(value = "id") long id){
        mentorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/mentores")
    public ResponseEntity <?> salvarMentor(@RequestBody @Valid MentorForm mentorForm, UriComponentsBuilder uriComponentsBuilder){
        Mentor mentor = mentorForm.converter();
        mentorService.save(mentor);
        URI uri = uriComponentsBuilder.path("/cadastrar/mentores/{id}").buildAndExpand(mentor.getId()).toUri();
        return ResponseEntity.created(uri).body(new MentorDto(mentor));
    }


}
