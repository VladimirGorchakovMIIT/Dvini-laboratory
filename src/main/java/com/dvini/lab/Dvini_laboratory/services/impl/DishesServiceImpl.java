package com.dvini.lab.Dvini_laboratory.services.impl;

import com.dvini.lab.Dvini_laboratory.models.Dishes;
import com.dvini.lab.Dvini_laboratory.repositories.DishesRepository;
import com.dvini.lab.Dvini_laboratory.services.DishesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishesServiceImpl implements DishesService {
    private final DishesRepository dishesRepository;

    @Override
    public List<Dishes> getAll() {
        return dishesRepository.findAll();
    }

    @Override
    public Dishes getById(int dishesID) {
        Optional<Dishes> optional = dishesRepository.findById(dishesID);
        Dishes dishes = new Dishes();

        if(optional.isPresent())
            dishes = optional.get();

        return dishes;
    }

    @Override
    public String create(Dishes dishes) {
        String result = "Object not created";

        if (dishes != null) {
            dishesRepository.save(dishes);
            result = "Object was created";
        }
        return result;
    }

    @Override
    public String update(Dishes updateDishes, int dishesId) {
        String result = "Object not updated";
        Dishes dishes = getById(dishesId);

        if(dishes != null && updateDishes != null){
            dishes.setName(updateDishes.getName());
            dishes.setDescription(updateDishes.getDescription());
            dishes.setCost(updateDishes.getCost());
            dishes.setOwner(updateDishes.getOwner());

            create(dishes);

            result = "Object was updated";
        }

        return result;
    }

    @Override
    public String deleteById(int dishesId) {
        String result = "Object not deleted";

        if(getById(dishesId) != null){
            dishesRepository.deleteById(dishesId);
            result = "Object was successfully deleted";
        }

        return result;
    }
}
