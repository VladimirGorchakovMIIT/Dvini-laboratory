package com.dvini.lab.Dvini_laboratory.controllers.graphql;

import com.dvini.lab.Dvini_laboratory.models.Dishes;
import com.dvini.lab.Dvini_laboratory.services.DishesService;
import com.dvini.lab.Dvini_laboratory.services.impl.CafeServiceImpl;
import com.dvini.lab.Dvini_laboratory.services.impl.DishesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DishesControllerGraphQL {
    private final DishesServiceImpl dishesService;
    private final CafeServiceImpl cafeService;

    @QueryMapping
    public List<Dishes> getAllDishes() {
        return dishesService.getAll();
    }

    @QueryMapping
    public Dishes getDishesById(@Argument int dishesId) {
        return dishesService.getById(dishesId);
    }

    @MutationMapping
    public String createDishes(@Argument DishesInput dishesInput, @Argument int ownerId) {
        Dishes dishes = new Dishes(dishesInput.name, dishesInput.description, Double.parseDouble(dishesInput.cost.toString()), cafeService.getById(ownerId));
        return dishesService.create(dishes);
    }

    @MutationMapping
    public String updateDishes(@Argument DishesInput dishesInput, @Argument int ownerID, @Argument int dishesId){
        Dishes dishes = new Dishes(dishesInput.name, dishesInput.description, Double.parseDouble(dishesInput.cost.toString()), cafeService.getById(ownerID));
        return dishesService.update(dishes, dishesId);
    }

    @MutationMapping
    public String deleteDishesById(@Argument int dishesId){
        return dishesService.deleteById(dishesId);
    }

    private record DishesInput(String name, String description, Float cost) {
    }
}
