package com.recipeland.queryResult;

import com.recipeland.pojo.Recipe;
import com.recipeland.pojo.User;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

//Query result for RecipeRepository
@QueryResult
public class UserToRecipeQueryResult{
    private User user;
    private List<Recipe> recipe;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }
}