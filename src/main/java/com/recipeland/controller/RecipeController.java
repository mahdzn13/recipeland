package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.saver.RecipeSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RecipeController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeSaver recipeSaver;

    @RequestMapping("/createRecipe")
    public void createRecipe(String recipeName, String recipeImage){
        recipeSaver.recipeSaver(recipeName,recipeImage);
     }

    @RequestMapping("/createRecipes")
    public void createRecipes(){
        recipeSaver.recipeSaver("Sausage with fries", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        recipeSaver.recipeSaver("Pizza Hawaii", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        recipeSaver.recipeSaver("Spaghetti", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
    }

    @RequestMapping("/getRecipeNode")
    public Recipe getRecipeNode(String recipeName){
        return recipeRepository.getRecipeNode(recipeName);
    }

    @RequestMapping("/getAllRecipes")
    public List<Recipe> getAllRecipes(){
        return recipeRepository.getAllRecipes();
    }

    @RequestMapping("/deleteRecipes")
    public void deleteAllRecipes(){
        recipeRepository.deleteAll();
    }
}
