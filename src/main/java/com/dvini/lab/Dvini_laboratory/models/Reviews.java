package com.dvini.lab.Dvini_laboratory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Reviews extends BaseModels{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "estimation")
    private Float estimation;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cafe_id", referencedColumnName = "id")
    private Cafe owner;

    public Reviews() {
    }
    public Reviews(String title, String description, Float estimation, Cafe owner) {
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", estimation=" + estimation +
                ", owner=" + owner +
                '}';
    }
}
