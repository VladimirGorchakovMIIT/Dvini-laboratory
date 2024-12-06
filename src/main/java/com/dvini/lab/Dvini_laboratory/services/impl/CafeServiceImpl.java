package com.dvini.lab.Dvini_laboratory.services.impl;

import com.dvini.lab.Dvini_laboratory.models.Cafe;
import com.dvini.lab.Dvini_laboratory.repositories.CafeRepository;
import com.dvini.lab.Dvini_laboratory.services.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {
    private final CafeRepository cafeRepository;

    @Override
    public List<Cafe> getAll() {
        return cafeRepository.findAll();
    }

    @Override
    public Cafe getById(int cafeId) {
        return cafeRepository.findById(cafeId).orElse(null);
    }

    @Override
    public String create(Cafe cafe) {
        String result = "Create new object";
        cafeRepository.save(cafe);
        return result;
    }

    @Override
    public String update(Cafe updateCafe, int cafeId) {
        Cafe cafe = getById(cafeId);
        String result = "Error for updated object";
        if(cafe != null){
            cafe.setName(updateCafe.getName());
            cafe.setDescription(updateCafe.getDescription());

            create(cafe);

            result = "Object was successfully updated";
        }
        return result;
    }

    @Override
    public String deleteById(int cafeId) {
        String result = "Object not deleted";

        if(getById(cafeId) != null){
            cafeRepository.deleteById(cafeId);
            result = "Object was deleted";
        }

        return result;
    }
}
