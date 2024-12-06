package com.dvini.lab.Dvini_laboratory.controllers.graphql;

import com.dvini.lab.Dvini_laboratory.models.Cafe;
import com.dvini.lab.Dvini_laboratory.models.Reviews;
import com.dvini.lab.Dvini_laboratory.services.impl.CafeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CafeControllerGraphQL {
    private final CafeServiceImpl cafeService;

    @QueryMapping
    public List<Cafe> getAllCafe(){
        return cafeService.getAll();
    }

    @QueryMapping
    public Cafe getCafeById(@Argument int cafeId){
        return cafeService.getById(cafeId);
    }

    @MutationMapping
    public String createCafe(@Argument CafeInput cafeInput){
        Cafe cafe = new Cafe(cafeInput.name, cafeInput.description, new ArrayList<>(), new ArrayList<>());
        return cafeService.create(cafe);
    }

    @MutationMapping
    private String updateCafe(@Argument int cafeId, @Argument CafeInput cafeInput){
        Cafe cafe = new Cafe(cafeInput.name, cafeInput.description, new ArrayList<>(), new ArrayList<>());
        return cafeService.update(cafe, cafeId);
    }

    @MutationMapping
    private String deleteCafeById(@Argument int cafeId){
        return cafeService.deleteById(cafeId);
    }

    private record CafeInput(String name, String description){}
}
