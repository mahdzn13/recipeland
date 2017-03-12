package com.recipeland.Controller;


import com.recipeland.pojo.Recipe;
import com.recipeland.repository.RecipeRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("/users")
    public List<Recipe> usuarios(){
        return (List<Recipe>) recipeRepository.findAll();
    }
}
