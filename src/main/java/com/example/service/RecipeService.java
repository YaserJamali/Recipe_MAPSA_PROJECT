package com.example.service;

import com.example.model.Ingredients;
import com.example.model.Recipe;
import com.example.repository.RecipeRepository;
import com.google.gson.Gson;

import java.util.List;
import java.util.Set;

public class RecipeService extends BaseService<Recipe, String> {

    private static RecipeService instance;
  private final RecipeRepository repo;
    private RecipeService() {
         repo = RecipeRepository.getInstance();
    }

    public static RecipeService getInstance() {
        if (instance == null) {
            instance = new RecipeService();
        }
        return instance;
    }


    @Override
    public void save(Recipe recipe) {
        repo.save(recipe);

    }

    @Override
    public void update(Recipe recipe) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public String findById(Long id) {
        return null;
    }

    @Override
    public List<Recipe> findAll(Recipe recipe) {
        return null;
    }

    @Override
    public List<Recipe> findByExample(String s) {
        return null;
    }

    @Override
    public List<Recipe> getAll() {
        return null;
    }

    public String saveAction(String name, String directions, String instructions, Set<Ingredients> ingredientsList) {
        if (name != null && directions != null && instructions != null) {
            Recipe recipe = new Recipe();
            recipe.setName(name);
            recipe.setDirections(directions);
            recipe.setInstructions(instructions);
            recipe.setIngredients(ingredientsList);
            save(recipe);
            return new Gson().toJson(recipe.toString());
        }
        else return new Gson().toJson("ERROR: Please Fill All Fields");
    }
}
