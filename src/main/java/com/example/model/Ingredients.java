package com.example.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "IngredientsEntity")
@Table(name = "INGREDIENTS_TABLE")
public class Ingredients implements Serializable {

    @Id()
    @Column(name = "ID_RECIPES")
    @SequenceGenerator(name = "ingredientSeq", sequenceName = "INGREDIENTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredientSeq")
    private long id;

    @Column(name = "NAME_INGREDIENTS")
    private String name;


    //getters and setters


    public Long getId() {
        return id;
    }

    public Ingredients setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ingredients setName(String name) {
        this.name = name;
        return this;
    }

    //toString


    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
