package com.example.repository;

import com.example.model.Recipe;
import com.example.utils.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RecipeRepository extends BaseRepository<Recipe> {




    private final EntityManager em;

    private final EntityTransaction tr;


    private static RecipeRepository instance;


    private RecipeRepository() {
        em = JPA.getInstance().getEntityManager();
        tr = em.getTransaction();
    }
    public static RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    @Override
    public Recipe save(Recipe recipe) {
        EntityManager manager = JPA.getInstance().getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(recipe);
        transaction.commit();
        manager.close();
        return recipe;
    }

    @Override
    public Recipe update(Recipe recipeRepo) {
        return null;
    }

    @Override
    public Recipe findById(Long id) {
        return null;
    }

    @Override
    public Recipe deleteById(Long id) {
        return null;
    }
}
