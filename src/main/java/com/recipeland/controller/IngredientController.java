package com.recipeland.controller;


import com.recipeland.pojo.Ingredient;
import com.recipeland.repository.IngredientRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IngredientController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private IngredientRepository ingredientRepository;

    @RequestMapping("/createIngredients")
    public void createIngredients(){
        //Creation of the data
        Ingredient manzana = new Ingredient("Manzana");
        Ingredient pepinillo = new Ingredient("Pepinillo");
        Ingredient lomo = new Ingredient("Lomo");

        //Creation of nodes using the data
        ingredientRepository.save(manzana);
        ingredientRepository.save(pepinillo);
        ingredientRepository.save(lomo);
    }

    @RequestMapping("/deleteIngredients")
    public void deleteAllIngredients(){
       ingredientRepository.deleteAll();
    }
}