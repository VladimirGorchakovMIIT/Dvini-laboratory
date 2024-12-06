package com.dvini.lab.Dvini_laboratory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dishes extends BaseModels{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Double cost;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cafe_id", referencedColumnName = "id")
    private Cafe owner;

    public Dishes() {
    }

    public Dishes(String name, String descriptions, Double cost, Cafe owner) {
        this.name = name;
        this.description = descriptions;
        this.cost = cost;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "name='" + name + '\'' +
                ", descriptions='" + description + '\'' +
                ", cost=" + cost +
                ", owner=" + owner +
                '}';
    }
}
