package com.recipeland.repository;


import com.recipeland.queryResult.UserToRecipeQueryResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import com.recipeland.pojo.Recipe;

import java.util.List;


@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {

    /* General queries */
    @Query("MATCH (r:Recipe {name:{0}}) RETURN r")
    public Recipe getRecipeNode(String recipeName);

    @Query("MATCH (r:Recipe) RETURN r ORDER BY r.name DESC")
    public List<Recipe> getAllRecipes();

    /* Recipe queries */
    @Query("MATCH (i:Ingredient)<-[:CAN_SUBSTITUTE]-(in:Ingredient)-[:SUBSTITUTE]->(r:Recipe) WHERE i.nodeId IN {0} RETURN r")
    public List<Recipe> getRecipesWithIngredientsAndSubstitutes(List<String> ingredientNodeIdArray);

    @Query("MATCH (i:Ingredient)-[:PART_OF]->(r:Recipe) WHERE i.nodeId IN {0} RETURN r")
    public List<Recipe> getRecipesWithIngredients(List<String> ingredientNodeIdArray);

    /* Relationship queries */
    //Gets
    @Query("MATCH (u:User)-[:FAVED]->(r:Recipe)<-[:CREATED]-(uc:User) WHERE u.nodeId = {0} RETURN COLLECT(r) as recipe,uc as user")
    List<Recipe> getFavedRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:BLACKLISTED]->(r:Recipe) WHERE u.nodeId = {0} RETURN r")
    List<Recipe> getBlacklistedRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:SEE_LATER]->(r:Recipe)<-[:CREATED]-(uc:User) WHERE u.nodeId = {0} RETURN COLLECT(r) as recipe,uc as user")
    List<Recipe> getSeeLaterRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:CREATED]->(r:Recipe) WHERE u.nodeId = {0} RETURN COLLECT(r) as recipe,u as user")
    UserToRecipeQueryResult getCreatedRecipes(String usernameNodeId);

    //Delete rel
    @Query("MATCH (u:User {nodeId:{0}})-[r:FAVED]->(rcp:Recipe {nodeId:{0}}) DELETE r")
    void removeFavedRecipe(String userNodeId, String recipeNodeId);

    @Query("MATCH (u:User {nodeId:{0}})-[r:BLACKLISTED]->(p:Recipe {nodeId:{0}}) DELETE r")
    void removeBlacklistedRecipe(String userNodeId, String recipeNodeId);

    @Query("MATCH (u:User {nodeId:{0}})-[r:SEE_LATER]->(rcp:Recipe {nodeId:{0}}) DELETE r")
    void removeSeeLaterRecipe(String userNodeId, String recipeNodeId);

    /*  Delete   */
    @Query("MATCH (u:User {nodeId:{0}})-[r:CREATED]->(rcp:Recipe {nodeId:{0}}) DETACH DELETE rcp")
    public void deleteRecipe(String userNodeId, String allergyNodeId);

}
