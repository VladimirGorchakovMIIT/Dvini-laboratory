package com.dvini.lab.Dvini_laboratory.controllers;

import com.dvini.lab.Dvini_laboratory.models.Reviews;
import com.dvini.lab.Dvini_laboratory.services.impl.ReviewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewsController {
    private final ReviewsServiceImpl reviewsService;

    @GetMapping
    public ResponseEntity<List<Reviews>> getAll(){
        return new ResponseEntity<>(reviewsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getById(@PathVariable("id") int reviewsId){
        return new ResponseEntity<>(reviewsService.getById(reviewsId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Reviews reviews){
        return new ResponseEntity<>(reviewsService.create(reviews), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id")int id, @RequestBody Reviews reviews){
        return new ResponseEntity<>(reviewsService.update(id, reviews), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int reviewsId){
        return new ResponseEntity<>(reviewsService.deleteById(reviewsId), HttpStatus.OK);
    }

}
