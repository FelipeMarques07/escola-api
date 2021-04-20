package br.com.insiders.escola.model;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
