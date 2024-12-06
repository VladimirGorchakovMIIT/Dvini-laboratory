package com.dvini.lab.Dvini_laboratory.controllers;

import com.dvini.lab.Dvini_laboratory.models.Dishes;
import com.dvini.lab.Dvini_laboratory.models.Reviews;
import com.dvini.lab.Dvini_laboratory.services.impl.DishesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishesController {
    private final DishesServiceImpl dishesService;

    @GetMapping
    public ResponseEntity<List<Dishes>> getAll(){
        return new ResponseEntity<>(dishesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dishes> getById(@PathVariable("id") int dishesId){
        return new ResponseEntity<>(dishesService.getById(dishesId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Dishes dishes){
        return new ResponseEntity<>(dishesService.create(dishes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id")int dishesId, @RequestBody Dishes dishes){
        return new ResponseEntity<>(dishesService.update(dishes, dishesId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int dishesId){
        return new ResponseEntity<>(dishesService.deleteById(dishesId), HttpStatus.OK);
    }
}
