package com.example;

import com.example.model.Ingredients;
import com.example.model.Recipe;
import com.example.repository.RecipeRepository;
import com.example.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

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

        Set<Ingredients> ingredientsSet= new HashSet<>();
        ingredientsSet.add(ingredient1);
        ingredientsSet.add(ingredient2);
        ingredientsSet.add(ingredient3);
        ingredientsSet.add(ingredient4);
        ingredientsSet.add(ingredient5);

        Recipe recipe=new Recipe();
        recipe.setCategory("Lunch")
                .setName("Pizza")
                .setCategory("Mexican")
                .setDirections("First Add Water then .....");
        recipe.getIngredients().add(ingredient1);
        recipe.getIngredients().add(ingredient2);
        recipe.getIngredients().add(ingredient3);
        recipe.getIngredients().add(ingredient4);
        recipe.getIngredients().add(ingredient5);


        System.out.println(RecipeService.getInstance().saveAction("Kalam Polo", "First Add Water then .....", "Mexican", ingredientsSet));

//        System.out.println(recipe);








    }
}
