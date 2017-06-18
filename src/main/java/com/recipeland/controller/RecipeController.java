package com.recipeland.controller;


import com.recipeland.pojo.Ingredient;
import com.recipeland.pojo.Recipe;

import com.recipeland.queryResult.UserToRecipeQueryResult;
import com.recipeland.repository.RecipeRepository;
import com.recipeland.saver.RecipeSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RecipeController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientController ingredientController;
    @Autowired
    private UserController userController;

    @Autowired
    private RecipeSaver recipeSaver;


      //////////////////////////////////
     //           CREATES            //
    //////////////////////////////////
    @RequestMapping("/createRecipe")
    public void createRecipe(HttpServletRequest request, HttpServletResponse response){
        //Extract all the data for the recipe
        String recipeNodeId = recipeSaver.recipeSaver(request.getParameter("recipeName"),request.getParameter("recipeImage"),request.getParameter("recipeText"));

        //Created by...
        userController.userCreatedRecipe(recipeNodeId,request.getParameter("userId"));

        //Get all recipes
        List<Ingredient> currentIngredients = ingredientController.getAllIngredients();

        //Vars for extract the data from the request
        int ingredientPosition = 0;
        boolean ingredientStillExist = true;
        List<String> ingredients = new ArrayList<>();


        //Gets all ingredients from the request, stops when it doesn't detect that item exist.
        while (ingredientStillExist){
            if (request.getParameterMap().get("ingredientArray[" + ingredientPosition + "]") != null){
                String posToFind = "ingredientArray[" + ingredientPosition + "]";
                String requestIngredientName = request.getParameterMap().get(posToFind)[0];
                ingredients.add(requestIngredientName);
                ingredientPosition++;
            } else {
                ingredientStillExist = false;
            }
        }

        //Var to keep the index
        int indexOfCurrentIngredient;

        //Create all ingredients and asociate with the recipe
        for (String ingredient : ingredients) {
            indexOfCurrentIngredient = 0;
            for (Ingredient currentIngredient : currentIngredients){
                if (Objects.equals(currentIngredient.getName().toUpperCase(), ingredient.toUpperCase())){
                    ingredientController.addIngredientToRecipe(recipeNodeId,currentIngredient.getNodeId());
                    break;
                } else if (indexOfCurrentIngredient == currentIngredients.size()-1){
                    ingredientController.addIngredientToRecipe(recipeNodeId,ingredientController.createIngredient(ingredient));
                }
                indexOfCurrentIngredient++;
            }
        }
     }

    @RequestMapping("/createRecipes")
    public void createRecipes(){
        recipeSaver.recipeSaver("Sausage with fries", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png","");
        recipeSaver.recipeSaver("Pizza Hawaii", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png","");
        recipeSaver.recipeSaver("Spaghetti", "http://www.allendeshnos.cl/image/cache/catalog/logos/perro-80x80.png","");
    }

      ///////////////////////////////////
     //             GETS              //
    ///////////////////////////////////
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
    public UserToRecipeQueryResult getCreatedRecipes(String userNodeId){
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

      ///////////////////////////////////
     //      Relationship removal     //
    ///////////////////////////////////
    @RequestMapping("/removeFavedRecipe")
    public void removeFavedRecipe(HttpServletRequest request, HttpServletResponse response){
        recipeRepository.removeFavedRecipe(request.getParameter("userNodeId"),request.getParameter("recipeNodeId"));

    }

    @RequestMapping("/removeBlacklistedRecipe")
    public void removeBlacklistedRecipe(HttpServletRequest request, HttpServletResponse response){
        recipeRepository.removeBlacklistedRecipe(request.getParameter("userNodeId"),request.getParameter("recipeNodeId"));

    }

      /////////////////////////////////
     //           Deletes           //
    /////////////////////////////////
    @RequestMapping("/deleteRecipes")
    public void deleteAllRecipes(){
        recipeRepository.deleteAll();
    }
}
