package com.dvini.lab.Dvini_laboratory.services.impl;

import com.dvini.lab.Dvini_laboratory.models.Reviews;
import com.dvini.lab.Dvini_laboratory.repositories.ReviewsRepository;
import com.dvini.lab.Dvini_laboratory.services.ReviewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Override
    public List<Reviews> getAll() {
        return reviewsRepository.findAll();
    }

    @Override
    public Reviews getById(int reviewId) {
        Optional<Reviews> optional = reviewsRepository.findById(reviewId);
        Reviews reviews = new Reviews();

        if (optional.isPresent())
            reviews = optional.get();

        return reviews;
    }

    @Override
    public String create(Reviews reviews) {
        String result = "Object not created";

        if (reviews != null) {
            reviewsRepository.save(reviews);
            result = "Object was created";
        }
        return result;
    }

    @Override
    public String update(int reviewsId, Reviews reviewsUpdated) {
        String result = "Object not updated";
        Reviews reviews = getById(reviewsId);
        
        if(reviewsUpdated != null && reviews != null){
            reviews.setTitle(reviewsUpdated.getTitle());
            reviews.setDescription(reviewsUpdated.getDescription());
            reviews.setEstimation(reviewsUpdated.getEstimation());
            reviews.setOwner(reviewsUpdated.getOwner());

            create(reviews);

            result = "Object was updated";
        }
        
        return result;
    }

    @Override
    public String deleteById(int reviewsId) {
        String result = "Object not deleted";

        if(getById(reviewsId) != null){
            reviewsRepository.deleteById(reviewsId);
            result = "Object was successfully deleted";
        }

        return result;
    }
}
