package com.recipeland.repository;


import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import com.recipeland.pojo.Recipe;

import java.util.List;


@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {
    @Query("MATCH (r:Recipe {name:{0}}) RETURN r")
    public Recipe getRecipeNode(String recipeName);

    @Query("MATCH (r:Recipe) RETURN r ORDER BY r.name DESC")
    public List<Recipe> getAllRecipes();

    @Query("MATCH (i:Ingredient)<-[:CAN_SUBSTITUTE]-(in:Ingredient)-[:SUBSTITUTE]->(r:Recipe) WHERE i.nodeId IN {0} AND (r)<-[:PART_OF]-(i) RETURN r")
    public List<Recipe> getRecipesWithIngredientsAndSubstitutes(List<String> ingredientNodeIdArray);

    @Query("MATCH (u:User)-[:FAVED]->(r:Recipe) WHERE u.nodeId = {0} RETURN r")
    public List<Recipe> getFavedRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:BLACKLISTED]->(r:Recipe) WHERE u.nodeId = {0} RETURN r")
    public List<Recipe> getBlacklistedRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:SEE_LATER]->(r:Recipe) WHERE u.nodeId = {0} RETURN r")
    public List<Recipe> getSeeLaterRecipes(String usernameNodeId);

    @Query("MATCH (u:User)-[:CREATED]->(r:Recipe) WHERE u.nodeId = {0} RETURN r")
    public List<Recipe> getCreatedRecipes(String usernameNodeId);
}
