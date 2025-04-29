package com.example.training1.level;


import com.example.training1.level.dto.LevelRequest;
import com.example.training1.level.dto.LevelResponse;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping
    ResponseEntity<Void> creareLevel(@RequestBody LevelRequest request) {
        levelService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<LevelResponse>> getAllLevel() {
        return ResponseEntity.ok(levelService.getAllLevel());
    }


    @GetMapping("{id}")
    ResponseEntity<LevelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.getById(id));
    }


    @PutMapping("{id}")
    ResponseEntity<Void> updateLevel(@PathVariable Long id , @RequestBody LevelRequest request) {
        levelService.updateLevel(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    ResponseEntity<Void> deleteLevel(@PathVariable Long id) {
        levelService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
