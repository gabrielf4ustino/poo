package br.bootcamp.project.controller;

import br.bootcamp.project.dto.BootcampDTO;
import br.bootcamp.project.service.BootcampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bootcamp")
public class BootcampController {

    @Autowired
    private BootcampService bootcampService;

    @PostMapping("create")
    public ResponseEntity<Boolean> create(@RequestBody BootcampDTO bootcampDTO) {
        return ResponseEntity.ok(bootcampService.persistBootcamp(bootcampDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<BootcampDTO>> getAll() {
        return ResponseEntity.ok(bootcampService.getAll());
    }
}
