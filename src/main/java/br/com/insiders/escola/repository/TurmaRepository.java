package br.com.insiders.escola.repository;

import br.com.insiders.escola.model.Mentor;
import br.com.insiders.escola.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

   Turma findById(long id);
}
