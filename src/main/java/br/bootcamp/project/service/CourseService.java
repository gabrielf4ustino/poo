package br.bootcamp.project.service;

import br.bootcamp.project.dto.CourseDTO;
import br.bootcamp.project.model.CourseModel;
import br.bootcamp.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public boolean persistCourse(CourseDTO courseDTO) {
        try {
            courseRepository.save(new CourseModel(courseDTO.getTitle(),courseDTO.getDescription(),courseDTO.getWorkload()));
        } catch (RuntimeException ignored) {
            return false;
        }
        return true;
    }

    public List<CourseDTO> getAll() {
        return courseRepository
                .findAll()
                .stream()
                .map(course -> new CourseDTO(course.getTitle(), course.getDescription(), course.getWorkload()))
                .collect(Collectors.toList());
    }
}
