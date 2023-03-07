package br.bootcamp.project.controller;

import br.bootcamp.project.dto.MentoringDTO;
import br.bootcamp.project.service.MentoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mentoring")
public class MentoringController {

    @Autowired
    private MentoringService mentoringService;

    @PostMapping("create")
    public ResponseEntity<Boolean> create(@RequestBody MentoringDTO mentoringDTO) {
        return ResponseEntity.ok(mentoringService.persistMentoring(mentoringDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<MentoringDTO>> getAll() {
        return ResponseEntity.ok(mentoringService.getAll());
    }
}
