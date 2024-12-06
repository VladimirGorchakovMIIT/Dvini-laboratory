package com.dvini.lab.Dvini_laboratory.services;

import com.dvini.lab.Dvini_laboratory.models.Cafe;

import java.util.List;

public interface CafeService {
    List<Cafe> getAll();
    Cafe getById(int cafeId);
    String create(Cafe cafe);
    String update(Cafe updateCafe, int cafeId);
    String deleteById(int cafeId);
}
