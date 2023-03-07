package br.bootcamp.project.service;

import br.bootcamp.project.dto.MentoringDTO;
import br.bootcamp.project.model.MentoringModel;
import br.bootcamp.project.repository.MentoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentoringService {

    @Autowired
    private MentoringRepository mentoringRepository;

    public boolean persistMentoring(MentoringDTO mentoringDTO) {
        try {
            mentoringRepository.save(new MentoringModel(mentoringDTO.getTitle(), mentoringDTO.getDescription(), LocalDate.now()));
        } catch (RuntimeException ignored) {
            return false;
        }
        return true;
    }

    public List<MentoringDTO> getAll() {
        return mentoringRepository
                .findAll()
                .stream()
                .map(model -> new MentoringDTO(model.getTitle(), model.getDescription(), model.getDate()))
                .collect(Collectors.toList());
    }
}
