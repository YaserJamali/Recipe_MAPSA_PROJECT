package com.example.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "IngredientsEntity")
@Table(name = "INGREDIENTS_TABLE")
@NamedQueries({
        @NamedQuery(name = "INGREDIENTS_FIND_ALL", query = "SELECT i FROM IngredientsEntity i"),
        @NamedQuery(name = "INGREDIENTS_FIND_BY_NAME", query = "SELECT i FROM IngredientsEntity i WHERE lower(i.name) like lower(:name) ")
})
public class Ingredients implements Serializable {

    //Properties

    @Id()
    @Column(name = "ID_RECIPES")
    @SequenceGenerator(name = "ingredientSeq", sequenceName = "INGREDIENTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredientSeq")
    private long id;

    @Column(name = "NAME_INGREDIENTS")
    private String name;

    //Named Queries
    public static final String INGREDIENTS_FIND_ALL="INGREDIENTS_FIND_ALL";
    public static final String INGREDIENTS_FIND_BY_NAME="INGREDIENTS_FIND_BY_NAME";



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
