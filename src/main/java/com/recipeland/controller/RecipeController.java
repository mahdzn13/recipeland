package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("/createRecipes")
    public void createRecipes(){
        //Creation of the data
        Recipe volcano = new Recipe("Volcano");
        Recipe lasagna = new Recipe("Lasagna");
        Recipe bacalao = new Recipe("Bacalao al pin pin");

        //Creation of nodes using the data
        recipeRepository.save(volcano);
        recipeRepository.save(lasagna);
        recipeRepository.save(bacalao);

        //EXAMPLE return statement with query
        // return (List<Recipe>) recipeRepository.findAll();
    }

    @RequestMapping("/getRecipeId")
    public Recipe getRecipeId(String recipeName){
        return recipeRepository.getRecipeId(recipeName);
    }

    @RequestMapping("/deleteRecipes")
    public void deleteAllRecipes(){
        recipeRepository.deleteAll();
    }
}
