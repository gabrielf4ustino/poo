package br.bootcamp.project.repository;

import br.bootcamp.project.model.DevModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<DevModel, Long> {

    DevModel findByName(String name);
}
