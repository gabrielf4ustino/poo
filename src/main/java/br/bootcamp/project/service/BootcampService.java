package br.bootcamp.project.service;

import br.bootcamp.project.dto.BootcampDTO;
import br.bootcamp.project.model.BootcampModel;
import br.bootcamp.project.repository.BootcampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootcampService {

    @Autowired
    private BootcampRepository bootcampRepository;

    public boolean persistBootcamp(BootcampDTO bootcampDTO) {
        try {
            bootcampRepository.save(new BootcampModel(bootcampDTO.getName(), bootcampDTO.getDescription(), bootcampDTO.getContents(), bootcampDTO.getDevs()));
        } catch (RuntimeException ignored) {
            return false;
        }
        return true;
    }

    public List<BootcampDTO> getAll() {
        return bootcampRepository
                .findAll()
                .stream()
                .map(bootcamp -> new BootcampDTO(bootcamp.getName(), bootcamp.getDescription(), bootcamp.getContents(), bootcamp.getDevs()))
                .collect(Collectors.toList());
    }
}
