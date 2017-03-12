package com.recipeland.Controller;


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
        rc.deleteAllRecipes();
        uc.deleteAllUsers();
        ic.deleteAllIngredients();

        //Inserts
        rc.createRecipes();
        uc.createUsers();
        ic.createIngredients();
    }

}
