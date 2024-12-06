package com.dvini.lab.Dvini_laboratory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cafe")
public class Cafe extends BaseModels{
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "owner")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "owner")
    private List<Dishes> dishes;

    public Cafe() {
    }

    public Cafe(String name, String description, List<Reviews> reviews, List<Dishes> dishes) {
        this.name = name;
        this.description = description;
        this.reviews = reviews;
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
