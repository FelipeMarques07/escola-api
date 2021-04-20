package br.com.insiders.escola.controller;

import br.com.insiders.escola.controller.dto.AlunoDto;
import br.com.insiders.escola.controller.dto.TurmaDto;
import br.com.insiders.escola.controller.form.AlunoForm;
import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Turma;
import br.com.insiders.escola.service.AlunoService;
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
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/alunos")
    public ResponseEntity <List<AlunoDto>> listarAluno(){
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok(AlunoDto.converter(alunos));
    }

    @GetMapping("/alunos/{id}")
    public  ResponseEntity <AlunoDto> buscarAluno(@PathVariable(value = "id") long id){
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok(new AlunoDto(aluno));
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity <?> deletarAluno(@PathVariable(value = "id") long id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    } 


    @PostMapping("/alunos")
    public ResponseEntity <?> salvarAluno(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder uriComponentsBuilder){
        Aluno aluno = alunoForm.converter(turmaService);
        alunoService.save(aluno);
        URI uri = uriComponentsBuilder.path("/cadastrar/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }

}
