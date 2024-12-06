package com.dvini.lab.Dvini_laboratory.controllers;

import com.dvini.lab.Dvini_laboratory.models.Cafe;
import com.dvini.lab.Dvini_laboratory.services.impl.CafeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeServiceImpl cafeService;

    @GetMapping()
    public ResponseEntity<List<Cafe>> getAllCafe(){
        return new ResponseEntity<>(cafeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cafe> getCafeById(@PathVariable("id") int cafeId){
        return new ResponseEntity<>(cafeService.getById(cafeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Cafe cafe){
        return new ResponseEntity<>(cafeService.create(cafe), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int cafeId, @RequestBody Cafe updateCafe){
        return new ResponseEntity<>(cafeService.update(updateCafe, cafeId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int cafeId){
        return new ResponseEntity<>(cafeService.deleteById(cafeId), HttpStatus.OK);
    }
}
