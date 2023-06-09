package com.example.repository;

import com.example.model.Ingredients;
import com.example.utils.JPA;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class IngredientsRepo extends BaseRepo<Ingredients>{





    private static IngredientsRepo instance;



    private IngredientsRepo() {

    }


    public static IngredientsRepo getInstance() {

            if (instance == null) {
                instance = new IngredientsRepo();

        }
        return instance;
    }




    @Override
    public Ingredients save(Ingredients ingredients) {
        EntityManager manager = JPA.getInstance().getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(ingredients);
        transaction.commit();
        manager.close();
        return ingredients;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        return null;
    }

    @Override
    public Ingredients findById(Long id) {
        return null;
    }

    @Override
    public Ingredients deleteById(Long id) {
        return null;
    }
}
