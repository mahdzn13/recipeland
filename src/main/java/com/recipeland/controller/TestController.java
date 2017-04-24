package com.recipeland.controller;


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

    @Autowired
    private AllergyController ac;

    @RequestMapping("/serveAll")
    public void AIO(){
        //Deletes
        /*
        rc.deleteAllRecipes();
        uc.deleteAllUsers();
        ic.deleteAllIngredients();
        ac.deleteAllAllergys();
        */

        //Inserts

        //Recipe inserts
        /*
        rc.createRecipe("Turkey chili jacket potatoes","https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1071476_11.jpg?itok=L5URpV6Y");
        rc.createRecipe("Cheap-as-chips veggie pizza","https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1096503_11.jpg?itok=cjnugggJ");
        rc.createRecipe("Quick mushroom & spinach lasagna","https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--735467_11.jpg?itok=5-MZ3rNZ");
        rc.createRecipe("Refried bean quesadillas","https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--365499_11.jpg?itok=5ok7D5Hi");
         */
        //Ingredients inserts
        ic.createIngredient("potato");
        ic.createIngredient("olive oil");
        ic.createIngredient("onion");
        ic.createIngredient("garlic");
        ic.createIngredient("turkey");
        ic.createIngredient("tomato");
        ic.createIngredient("cheese");

        ic.createIngredient("flat bread");
        ic.createIngredient("spinach");
        ic.createIngredient("mozzarella");
        ic.createIngredient("egg");
        ic.createIngredient("nutmeg");
        ic.createIngredient("basil");
        ic.createIngredient("parmesan");

        ic.createIngredient("mushroom");
        ic.createIngredient("lasagna sheet");

        ic.createIngredient("kidney bean");
        ic.createIngredient("tortilla");
        ic.createIngredient("cheddar");
        ic.createIngredient("coriander");
        ic.createIngredient("tomato sauce");

        //Users inserts
        uc.createUser("ralphy","ralphy@recipeland.com","Ralph","The One");
        uc.createUser("mahernandezd","mahernandezd@recipeland.com","Marco","Hernandez");

        //Allergies inserts
        ac.createAllergy("wheat allergy","Caused by wheat");
        ac.createAllergy("egg allergy","Caused by egg");
        ac.createAllergy("milk allergy","Caused by milk");
        ac.createAllergy("spice allergy","Caused by spices");

        //Relationships :CREATED
        uc.userCreatedRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),uc.getUserNode("ralphy").getNodeId());
        uc.userCreatedRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),uc.getUserNode("ralphy").getNodeId());
        uc.userCreatedRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),uc.getUserNode("ralphy").getNodeId());
        uc.userCreatedRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),uc.getUserNode("ralphy").getNodeId());

        //User mahernandezd :faved,blacklisted,seelater
        uc.userFavedRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),uc.getUserNode("mahernandezd").getNodeId());

        uc.userBlacklistedRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),uc.getUserNode("mahernandezd").getNodeId());

        uc.userSeeLaterRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),uc.getUserNode("mahernandezd").getNodeId());
        uc.userSeeLaterRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),uc.getUserNode("mahernandezd").getNodeId());


        //Relationships :PART_OF
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("potato").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("olive oil").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("onion").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("garlic").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("turkey").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("tomato").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("cheese").getNodeId());

        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("tomato").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("flat bread").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("spinach").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("garlic").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("mozzarella").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("egg").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("nutmeg").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("basil").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("parmesan").getNodeId());

        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("olive oil").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("garlic").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("mushroom").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("spinach").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("cheese").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("parmesan").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("lasagna sheet").getNodeId());

        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("olive oil").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("onion").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("garlic").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("kidney bean").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("tortilla").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("cheddar").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("coriander").getNodeId());
        ic.addIngredientToRecipe(rc.getRecipeNode("Refried bean quesadillas").getNodeId(),ic.getIngredientNode("tomato sauce").getNodeId());

        //Relationships :CAN_SUBSTITUTE
        ic.ingredientCanSubstitute(ic.getIngredientNode("tomato sauce").getNodeId(),ic.getIngredientNode("tomato").getNodeId());
        ic.ingredientCanSubstitute(ic.getIngredientNode("mozzarella").getNodeId(),ic.getIngredientNode("cheese").getNodeId());
        ic.ingredientCanSubstitute(ic.getIngredientNode("parmesan").getNodeId(),ic.getIngredientNode("cheese").getNodeId());
        ic.ingredientCanSubstitute(ic.getIngredientNode("cheddar").getNodeId(),ic.getIngredientNode("cheese").getNodeId());
        ic.ingredientCanSubstitute(ic.getIngredientNode("cheddar").getNodeId(),ic.getIngredientNode("mozzarella").getNodeId());

        //Relationships :SUBSTITUTE
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("cheddar").getNodeId());
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("mozzarella").getNodeId());
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("parmesan").getNodeId());
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Turkey chili jacket potatoes").getNodeId(),ic.getIngredientNode("tomato sauce").getNodeId());

        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("tomato sauce").getNodeId());
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Cheap-as-chips veggie pizza").getNodeId(),ic.getIngredientNode("cheddar").getNodeId());

        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("cheddar").getNodeId());
        ic.addSubstituteIngredientToRecipe(rc.getRecipeNode("Quick mushroom & spinach lasagna").getNodeId(),ic.getIngredientNode("mozzarella").getNodeId());

        //Relationships :CAN_PRODUCE
        ic.addIngredientAllergy(ac.getAllergyNode("wheat allergy").getNodeId(),ic.getIngredientNode("flat bread").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("wheat allergy").getNodeId(),ic.getIngredientNode("lasagna sheet").getNodeId());

        ic.addIngredientAllergy(ac.getAllergyNode("egg allergy").getNodeId(),ic.getIngredientNode("egg").getNodeId());

        ic.addIngredientAllergy(ac.getAllergyNode("milk allergy").getNodeId(),ic.getIngredientNode("cheese").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("milk allergy").getNodeId(),ic.getIngredientNode("parmesan").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("milk allergy").getNodeId(),ic.getIngredientNode("mozzarella").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("milk allergy").getNodeId(),ic.getIngredientNode("cheddar").getNodeId());

        ic.addIngredientAllergy(ac.getAllergyNode("spice allergy").getNodeId(),ic.getIngredientNode("coriander").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("spice allergy").getNodeId(),ic.getIngredientNode("basil").getNodeId());
        ic.addIngredientAllergy(ac.getAllergyNode("spice allergy").getNodeId(),ic.getIngredientNode("nutmeg").getNodeId());


    }

}