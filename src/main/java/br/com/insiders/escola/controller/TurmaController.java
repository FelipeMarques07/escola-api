package br.com.insiders.escola.controller;

import br.com.insiders.escola.controller.dto.TurmaDto;
import br.com.insiders.escola.controller.form.TurmaForm;
import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/escola")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/turmas")
    public ResponseEntity <List<TurmaDto>> listarTurma (){
        List<Turma> turmas = turmaService.findAll();
        return ResponseEntity.ok(TurmaDto.converter(turmas));
    }

    @GetMapping("/turmas/{id}")
    public ResponseEntity <TurmaDto> buscarTurma(@PathVariable(value = "id") long id){
        Turma turma = turmaService.findById(id);
        return ResponseEntity.ok(new TurmaDto(turma));
    }

    @DeleteMapping("/turmas/{id}")
    public ResponseEntity <?> deletarTurma(@PathVariable(value = "id") long id){
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/turmas")
    public ResponseEntity <?> salvarTurma(@RequestBody @Valid TurmaForm turmaForm, UriComponentsBuilder uriComponentsBuilder){
        Turma turma = turmaForm.converter();
        turmaService.save(turma);
        URI uri = uriComponentsBuilder.path("/cadastrar/turmas/{id}").buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(new TurmaDto(turma));
    }




}
