package com.dvini.lab.Dvini_laboratory.services;

import com.dvini.lab.Dvini_laboratory.models.Cafe;
import com.dvini.lab.Dvini_laboratory.models.Dishes;

import java.util.List;

public interface DishesService {
    List<Dishes> getAll();
    Dishes getById(int dishesID);
    String create(Dishes dishes);
    String update(Dishes updateDishes, int dishesId);
    String deleteById(int dishesId);
}
