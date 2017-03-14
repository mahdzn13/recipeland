package com.recipeland.saver;

import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeSaver {
    @Autowired
    private Generator generator;

    @Autowired
    private RecipeRepository recipeRepository;

    public void recipeSaver(String recipeName, String image){
        //Creation of the data
        Recipe recipe = new Recipe(recipeName,image);

        //Create UUID
        generator.generateNodeId(recipe);

        //Creation of nodes using the data
        recipeRepository.save(recipe);
    }
}