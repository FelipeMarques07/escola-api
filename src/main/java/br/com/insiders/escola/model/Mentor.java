package br.com.insiders.escola.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mentor")
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "sobrenome", length = 50)
    private String sobrenome;

    @Column(name = "matricula")
    private int matricula;

    @OneToMany
    private List<Aluno> alunos = new ArrayList<Aluno>();;



    public Mentor() {
    }

    public Mentor(Long id, String nome, String sobrenome, int matricula, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.alunos= alunos;
    }

    public Mentor(String nome, String sobrenome, int matricula) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }

    public Mentor(Long id, String nome, String sobrenome, int matricula) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }

    public Mentor(Long id, List<Aluno> alunos) {
        this.id = id;
        this.alunos = alunos;
    }
}
