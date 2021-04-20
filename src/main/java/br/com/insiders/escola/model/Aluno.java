package br.com.insiders.escola.model;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "sobrenome", length = 50)
    private String sobrenome;

    @Column(name="matricula")
    private int matricula;

    @ManyToOne
    private Turma turma;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String sobrenome, int matricula, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.turma = turma;

    }

    public Aluno(String nome, String sobrenome, int matricula, Turma turma) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.turma = turma;
    }
}
