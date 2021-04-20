package br.com.insiders.escola.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
