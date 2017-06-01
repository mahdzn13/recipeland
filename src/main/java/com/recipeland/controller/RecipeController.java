package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.saver.RecipeSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
public class RecipeController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeSaver recipeSaver;

    //Working POST so now implement it lazy fuck
    @RequestMapping("/createRecipe")
    public void createRecipe(HttpServletRequest request, HttpServletResponse response){
        recipeSaver.recipeSaver(request.getParameter("recipeName"),request.getParameter("recipeImage"));
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
        ArrayList<Recipe> recipesPartOf = new ArrayList<> (recipeRepository.getRecipesWithIngredients(ingredientNameArray));
        ArrayList<Recipe> recipesWithSubstitutes = new ArrayList<> (recipeRepository.getRecipesWithIngredientsAndSubstitutes(ingredientNameArray));
        ArrayList<Recipe> compare;
        ArrayList<Recipe> result;

        if (recipesPartOf.size() > recipesWithSubstitutes.size()){
            result = recipesPartOf;
            compare = recipesWithSubstitutes;
        } else {
            result = recipesWithSubstitutes;
            compare = recipesPartOf;
        }

        for (int i = 0; i < result.size()-1; i++) {
            for (int j = 0; j < compare.size()-1; j++) {
                if (Objects.equals(result.get(i).getNodeId(), compare.get(j).getNodeId())){
                    break;
                } else if(j == compare.size()-1 && !Objects.equals(result.get(i).getNodeId(), compare.get(j).getNodeId())){
                    result.add(compare.get(j));
                }
            }
        }
        return result;
    }

    @RequestMapping("/deleteRecipes")
    public void deleteAllRecipes(){
        recipeRepository.deleteAll();
    }
}
