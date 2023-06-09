package com.example.model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.CascadeType.PERSIST;

@Entity(name = "Recipe")
@Table(name = "RECIPES_TABLE")
public class Recipe implements Serializable {

    @Id()
    @Column(name = "ID_RECIPES")
    @SequenceGenerator(name = "recipeSeq", sequenceName = "recipe_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSeq")
    private long id;

    @Column(name = "FOOD_NAME")
    private String name;

    @Column(name = "category_type")
    private String category;


    @Column(name = "date_time_created")
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "instructions_for_recipe")
    private String instructions;

    @OneToMany(cascade = PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "INTedIENTS_RECIPES_FK")
    private Set<Ingredients > ingredients = new HashSet<>();


    @Column(name = "directions_for_recipe")
    private String directions ;

    //getters and setters


    public long getId() {
        return id;
    }

    public Recipe setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Recipe setCategory(String category) {
        this.category = category;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Recipe setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public Recipe setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getDirections() {
        return directions;
    }

    public Recipe setDirections(String directions) {
        this.directions = directions;
        return this;
    }

    //toString


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", instructions='" + instructions + '\'' +
                ", ingredients=" + ingredients +
                ", directions='" + directions + '\'' +
                '}';
    }
}