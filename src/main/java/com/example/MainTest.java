package com.example;

import com.example.model.Ingredients;
import com.example.model.Recipe;
import com.example.repository.RecipeRepo;

public class MainTest {
    public static void main(String[] args) {

        Ingredients ingredient1 = new Ingredients();
        ingredient1.setName("Sugar");
        Ingredients ingredient2 = new Ingredients();
        ingredient2.setName("Milk");
        Ingredients ingredient3 = new Ingredients();
        ingredient3.setName("Union");
        Ingredients ingredient4 = new Ingredients();
        ingredient4.setName("Meet");
        Ingredients ingredient5 = new Ingredients();
        ingredient5.setName("Salt");

        Recipe recipe=new Recipe();
        recipe.setCategory("Lunch")
                .setName("Pizza")
                .setDirections("Mexican")
                .setDirections("First Add Water then .....");
        recipe.getIngredients().add(ingredient1);
        recipe.getIngredients().add(ingredient2);
        recipe.getIngredients().add(ingredient3);
        recipe.getIngredients().add(ingredient4);
        recipe.getIngredients().add(ingredient5);


        RecipeRepo.getInstance().save(recipe);

        System.out.println(recipe.toString());








    }
}
