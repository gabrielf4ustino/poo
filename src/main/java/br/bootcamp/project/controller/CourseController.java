package br.bootcamp.project.controller;

import br.bootcamp.project.dto.CourseDTO;
import br.bootcamp.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("create")
    public ResponseEntity<Boolean> create(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.persistCourse(courseDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<CourseDTO>> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }
}
