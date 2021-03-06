package br.com.insiders.escola.repository;

import br.com.insiders.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
