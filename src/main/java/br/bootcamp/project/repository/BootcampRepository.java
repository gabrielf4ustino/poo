package br.bootcamp.project.repository;

import br.bootcamp.project.model.BootcampModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends JpaRepository<BootcampModel, Long> {

    BootcampModel findByName(String name);
}
