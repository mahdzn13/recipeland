package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.saver.RecipeSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("/getBlacklistedRecipes")
    public List<Recipe> getBlacklistedRecipes(String userNodeId){
        return recipeRepository.getBlacklistedRecipes(userNodeId);
    }

    @RequestMapping("/getCreatedRecipes")
    public List<Recipe> getCreatedRecipes(String userNodeId){
        return recipeRepository.getCreatedRecipes(userNodeId);
    }

    @RequestMapping("/getSeeLaterRecipes")
    public List<Recipe> getSeeLaterRecipes(String userNodeId){
        return recipeRepository.getSeeLaterRecipes(userNodeId);
    }

    @RequestMapping("/getFavedRecipes")
    public List<Recipe> getFavedRecipes(String userNodeId){
        return recipeRepository.getFavedRecipes(userNodeId);
    }

    @RequestMapping("/getRecipesWithIngredientsAndSubstitutes")
    public List<Recipe> getRecipesWithIngredientsAndSubstitutes(String nodeId1,String nodeId2,String nodeId3,String nodeId4,String nodeId5,String nodeId6,String nodeId7){
        List<String> ingredientNameArray = new ArrayList<>(Arrays.asList(nodeId1,nodeId2,nodeId3,nodeId4,nodeId5,nodeId6,nodeId7));
        return recipeRepository.getRecipesWithIngredientsAndSubstitutes(ingredientNameArray);
    }

    @RequestMapping("/deleteRecipes")
    public void deleteAllRecipes(){
        recipeRepository.deleteAll();
    }
}
