package com.recipeland.Controller;


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

    @RequestMapping("/users")
    public List<Ingredient> usuarios(){
        return (List<Ingredient>) ingredientRepository.findAll();
    }
}