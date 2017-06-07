package com.recipeland.controller;


import com.recipeland.pojo.Ingredient;
import com.recipeland.repository.IngredientRepository;
import com.recipeland.saver.IngredientSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class IngredientController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientSaver ingredientSaver;

    @RequestMapping("/createIngredient")
    public String createIngredient(String ingredientName){
        return ingredientSaver.ingredientSaver(ingredientName);
    }

    @RequestMapping("/createIngredients")
    public void createIngredients(){
        ingredientSaver.ingredientSaver("Pineapple");
        ingredientSaver.ingredientSaver("Apple");
        ingredientSaver.ingredientSaver("Tuna");
    }

    @RequestMapping("/addIngredientToRecipe")
    public void addIngredientToRecipe(String recipeNodeId,String ingredientNodeId){
        ingredientRepository.addIngredientToRecipe(recipeNodeId, ingredientNodeId);
    }

    @RequestMapping("/addSubstituteIngredientToRecipe")
    public void addSubstituteIngredientToRecipe(String recipeNodeId,String ingredientNodeId){
        ingredientRepository.addSubstituteIngredientToRecipe(recipeNodeId,ingredientNodeId);
    }

    @RequestMapping("/addIngredientAllergy")
    public void addIngredientAllergy(String allergyNodeId,String ingredientNodeId){
        ingredientRepository.addIngredientAllergy(allergyNodeId,ingredientNodeId);
    }

    @RequestMapping("/ingredientCanSubstitute")
    public void ingredientCanSubstitute(String ingredientNodeId1,String ingredientNodeId2){
        ingredientRepository.ingredientCanSubstitute(ingredientNodeId1,ingredientNodeId2);
    }

    @RequestMapping("/getIngredientNode")
    public Ingredient getIngredientNode(String ingredientName){
        return ingredientRepository.getIngredientNode(ingredientName);
    }

    @RequestMapping("/getAllIngredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }

    @RequestMapping("/deleteIngredients")
    public void deleteAllIngredients(){
       ingredientRepository.deleteAll();
    }
}