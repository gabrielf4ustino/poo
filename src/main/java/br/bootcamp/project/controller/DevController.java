package br.bootcamp.project.controller;

import br.bootcamp.project.dto.DevDTO;
import br.bootcamp.project.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dev")
public class DevController {

    @Autowired
    private DevService devService;

    @PostMapping("create")
    public ResponseEntity<Boolean> create(@RequestBody DevDTO devDTO) {
        return ResponseEntity.ok(devService.persistDev(devDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<DevDTO>> getAll() {
        return ResponseEntity.ok(devService.getAll());
    }

    @GetMapping("xp/{name}")
    public ResponseEntity<Double> getXp(@PathVariable String name) {
        return ResponseEntity.ok(devService.calculateXp(name));
    }

    @PutMapping("progress/{name}")
    public ResponseEntity progress(@PathVariable String name) {
        devService.progress(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("subscribe/bootcamp/{bootcamp}/{name}")
    public ResponseEntity subscribeBootcamp(@PathVariable String bootcamp, @PathVariable String name){
        devService.subscribeBootcamp(bootcamp, name);
        return ResponseEntity.ok().build();
    }
}
