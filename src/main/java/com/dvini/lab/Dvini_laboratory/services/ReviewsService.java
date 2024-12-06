package com.dvini.lab.Dvini_laboratory.services;

import com.dvini.lab.Dvini_laboratory.models.Reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewsService {
    List<Reviews> getAll();
    Reviews getById(int reviewId);
    String create(Reviews reviews);
    String update(int reviewsId, Reviews reviews);
    String deleteById(int reviewsId);
}
