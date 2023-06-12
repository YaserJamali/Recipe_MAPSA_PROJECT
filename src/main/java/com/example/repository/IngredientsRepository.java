package com.example.repository;

import com.example.model.Ingredients;
import com.example.utils.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class IngredientsRepository extends BaseRepository<Ingredients> {


    private final EntityManager em;

    private final EntityTransaction tr;


    private static IngredientsRepository instance;


    private IngredientsRepository() {
        em = JPA.getInstance().getEntityManager();
        tr = em.getTransaction();
    }


    public static IngredientsRepository getInstance() {
        if (instance == null) {
            instance = new IngredientsRepository();
        }
        return instance;
    }


    @Override
    public Ingredients save(Ingredients ingredients) {
        tr.begin();
        em.persist(ingredients);
        tr.commit();
        em.close();
        return ingredients;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        tr.begin();
        em.merge(ingredients);
        tr.commit();
        em.close();
        return ingredients;
    }

    @Override
    public Ingredients findById(Long id) {
        Ingredients ingredients = em.find(Ingredients.class, id);
        em.close();
        return ingredients;
    }

    @Override
    public Ingredients deleteById(Long id) {
        Ingredients ingredients = em.find(Ingredients.class, id);
        tr.begin();
        em.remove(ingredients);
        tr.commit();
        em.close();
        return ingredients;
    }

    public List<Ingredients> findAll() {
        TypedQuery<Ingredients> query = em.createNamedQuery(Ingredients.INGREDIENTS_FIND_ALL, Ingredients.class);
        List<Ingredients> ingredients = query.getResultList();
        em.close();
        return ingredients;
    }

    public Ingredients findByExample(String name) {
        Query query = em.createNamedQuery(Ingredients.INGREDIENTS_FIND_BY_NAME);
        query.setParameter("name", name);
        query.setMaxResults(1);
        Ingredients ingredient = (Ingredients) query.getSingleResult();
        em.close();
        return ingredient;
    }
}
