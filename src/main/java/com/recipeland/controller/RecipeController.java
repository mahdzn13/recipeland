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

    @RequestMapping("/createRecipes")
    public void createRecipes(){
        recipeSaver.recipeSaver("Volcano", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        recipeSaver.recipeSaver("Lasagna", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        recipeSaver.recipeSaver("Bacalado", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
    }

    @RequestMapping("/getRecipeId")
    public Recipe getRecipeId(String recipeName){
        return recipeRepository.getRecipeId(recipeName);
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
