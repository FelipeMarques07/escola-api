package br.com.insiders.escola.repository;

import br.com.insiders.escola.model.Aluno;
import br.com.insiders.escola.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {


}
