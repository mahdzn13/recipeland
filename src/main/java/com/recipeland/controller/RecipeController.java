package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
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

    @RequestMapping("/createRecipes")
    public void createRecipes(){
        //Creation of the data
        Recipe volcano = new Recipe("Volcano","http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        Recipe lasagna = new Recipe("Lasagna","http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");
        Recipe bacalao = new Recipe("Bacalao al pin pin","http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png");

        //Creation of nodes using the data
        recipeRepository.save(volcano);
        recipeRepository.save(lasagna);
        recipeRepository.save(bacalao);
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
