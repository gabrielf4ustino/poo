package br.bootcamp.project.repository;

import br.bootcamp.project.model.MentoringModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringRepository extends JpaRepository<MentoringModel, Long> {
}
