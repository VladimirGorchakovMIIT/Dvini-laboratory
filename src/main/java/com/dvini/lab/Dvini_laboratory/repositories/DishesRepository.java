package com.dvini.lab.Dvini_laboratory.repositories;

import com.dvini.lab.Dvini_laboratory.models.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, Integer> {
}
