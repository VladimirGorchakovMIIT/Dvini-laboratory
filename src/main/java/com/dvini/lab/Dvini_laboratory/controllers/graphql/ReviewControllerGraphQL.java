package com.dvini.lab.Dvini_laboratory.controllers.graphql;

import com.dvini.lab.Dvini_laboratory.models.Reviews;
import com.dvini.lab.Dvini_laboratory.services.impl.CafeServiceImpl;
import com.dvini.lab.Dvini_laboratory.services.impl.ReviewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewControllerGraphQL {
    private final ReviewsServiceImpl reviewsService;
    private final CafeServiceImpl cafeService;

    @QueryMapping
    public List<Reviews> getAllReviews(){
        return reviewsService.getAll();
    }

    @QueryMapping
    public Reviews getReviewsById(@Argument int reviewsId){
        return reviewsService.getById(reviewsId);
    }

    @MutationMapping
    public String createReviews(@Argument ReviewsInput reviewsInput, @Argument int ownerId){
        Reviews reviews = new Reviews(reviewsInput.title, reviewsInput.description, reviewsInput.estimation, cafeService.getById(ownerId));
        return reviewsService.create(reviews);
    }

    @MutationMapping
    private String updateReviews(@Argument int reviewsId, @Argument ReviewsInput reviewsInput, @Argument int ownerId){
        Reviews reviews = new Reviews(reviewsInput.title, reviewsInput.description, reviewsInput.estimation, cafeService.getById(ownerId));
        reviewsService.update(reviewsId, reviews);
        return "Was updated";
    }

    @MutationMapping
    private String deleteReviewsById(@Argument int reviewsID){
        return reviewsService.deleteById(reviewsID);
    }

    public record ReviewsInput(String title, String description, Float estimation){}
}
