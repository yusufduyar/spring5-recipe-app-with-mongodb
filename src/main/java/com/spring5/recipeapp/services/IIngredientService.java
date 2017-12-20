package com.spring5.recipeapp.services;

import com.spring5.recipeapp.commands.IngredientCommand;

public interface IIngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(String recipeId,String ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    void deleteById(String recipeId,String ingredientId);
}
