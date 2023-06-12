package com.example.service;

import com.example.model.Ingredients;
import com.example.repository.IngredientsRepository;
import com.google.gson.Gson;

import java.util.List;

public class IngredientsService extends BaseService<Ingredients, String> {
    private IngredientsService instance;
    private IngredientsRepository repo;

    private IngredientsService() {
        repo = IngredientsRepository.getInstance();
    }

    public IngredientsService getInstance() {
        if (instance == null) {
            instance = new IngredientsService();
        }
        return instance;
    }


    @Override
    public void save(Ingredients ingredients) {
        repo.save(ingredients);
    }

    @Override
    public void update(Ingredients ingredients) {
        repo.update(ingredients);
    }

    public String delete(Long id) {
        Ingredients ingredients = repo.findById(id);
        if (ingredients != null) {
            repo.deleteById(id);
            return new Gson().toJson("ingredients is deleted");
        } else return new Gson().toJson("ingredients is not deleted");
    }

    @Override
    public String findById(Long id) {
        Ingredients ingredients = repo.findById(id);
        return new Gson().toJson(ingredients);
    }

    @Override
    public List<Ingredients> findAll(Ingredients ingredients) {



        return null;
    }

    @Override
    public List<Ingredients> findByExample(String s) {
        return null;
    }

    @Override
    public List<Ingredients> getAll() {
        return repo.findAll();
    }


    public String saveAction(String name) {
        if (name != null) {
            Ingredients ingredients = new Ingredients();
            ingredients.setName(name);
            update(ingredients);
            return new Gson().toJson(ingredients);
        } else return null;
    }

    public String updateAction(String name, Long id) {
        if (name != null && id != null) {
            Ingredients ingredients = repo.findById(id);
            if (ingredients != null) {
                ingredients.setName(name)
                        .setId(id);
                save(ingredients);
                return new Gson().toJson(ingredients);
            } else return null;
        } else return null;
    }
}
