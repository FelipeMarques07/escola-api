package br.com.insiders.escola.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.time.Year;
import java.util.List;
@Builder
@Value
@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "quantidade_aluno")
    private int quantidadeAluno;

    @Column(name = "ano_letivo")
    private Year anoLetivo;


}
