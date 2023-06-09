package com.example.repository;

import com.example.model.Recipe;
import com.example.utils.JPA;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RecipeRepo extends BaseRepo<Recipe>{




    private static RecipeRepo instance;



    private RecipeRepo() {
    }


    public static RecipeRepo getInstance() {

            if (instance == null) {
                instance = new RecipeRepo();
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
