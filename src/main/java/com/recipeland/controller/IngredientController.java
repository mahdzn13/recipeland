package com.recipeland.controller;


import com.recipeland.pojo.Ingredient;
import com.recipeland.repository.IngredientRepository;
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

    @RequestMapping("/createIngredients")
    public void createIngredients(){
        //Creation of the data
        Ingredient pina = new Ingredient("Piña");
        Ingredient pepinillo = new Ingredient("Pepinillo");
        Ingredient lomo = new Ingredient("Lomo");

        //Creation of nodes using the data
        ingredientRepository.save(pina);
        ingredientRepository.save(pepinillo);
        ingredientRepository.save(lomo);
    }

    @RequestMapping("/addIngredientToRecipe")
    public void addIngredientToRecipe(Long recipeId,Long ingredientId){
        ingredientRepository.addIngredientToRecipe(recipeId, ingredientId);
    }

    @RequestMapping("/getIngredientId")
    public Ingredient getIngredientId(String ingredientName){
        return ingredientRepository.getIngredientId(ingredientName);
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