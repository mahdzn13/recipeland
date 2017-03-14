package com.recipeland.controller;


import com.recipeland.pojo.Ingredient;
import com.recipeland.repository.IngredientRepository;
import com.recipeland.saver.IngredientSaver;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IngredientController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientSaver ingredientSaver;

    @RequestMapping("/createIngredients")
    public void createIngredients(){
        ingredientSaver.ingredientSaver("Piña");
        ingredientSaver.ingredientSaver("Lomo");
        ingredientSaver.ingredientSaver("Atun");
    }

    @RequestMapping("/addIngredientToRecipe")
    public void addIngredientToRecipe(String recipeNodeId,String ingredientNodeId){
        ingredientRepository.addIngredientToRecipe(recipeNodeId, ingredientNodeId);
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