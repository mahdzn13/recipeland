package com.recipeland.saver;


import com.recipeland.pojo.Ingredient;
import com.recipeland.repository.IngredientRepository;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientSaver {
    @Autowired
    private Generator generator;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void ingredientSaver(String ingredientName){
        //Creation of the data
        Ingredient ingredient = new Ingredient(ingredientName);

        //Create UUID
        generator.generateNodeId(ingredient);

        //Creation of nodes using the data
        ingredientRepository.save(ingredient);
    }
}
