package com.recipeland.controller;


import com.recipeland.pojo.Recipe;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//////////////////////////////////////////////////////////////
//------------------------ TEST ONLY -------------------------
//////////////////////////////////////////////////////////////


/* Calls to all controllers */
@RestController
public class TestController {


    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private RecipeController rc;

    @Autowired
    private UserController uc;

    @Autowired
    private IngredientController ic;

    @RequestMapping("/serveAll")
    public void AIO(){
        //Deletes
        /*
        rc.deleteAllRecipes();
        uc.deleteAllUsers();
        ic.deleteAllIngredients();
        */

        //Inserts
        ic.createIngredients();
        rc.createRecipes();
        uc.createUsers();


        //Relationships
        /*
        Long id1,id2;
        id1 = rc.getRecipeId("Lasagna").getId();
        id2 = ic.getIngredientId("Lomo").getId();
        System.out.println(id1 +"|"+ id2);
        ic.addIngredientToRecipe(id1,id2);
        */
    }

}
