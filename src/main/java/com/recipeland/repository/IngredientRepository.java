package com.recipeland.repository;

import com.recipeland.pojo.Ingredient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends GraphRepository<Ingredient> {
    @Query("MATCH (r:Recipe {nodeId:{0}}), (i:Ingredient {nodeId:{1}}) CREATE (i)-[:PART_OF]->(r)")
    public void addIngredientToRecipe(String recipeNodeId, String ingredientNodeId);

    @Query("MATCH (r:Recipe {nodeId:{0}}), (i:Ingredient {nodeId:{1}}) CREATE (i)-[:SUBSTITUTE]->(r)")
    public void addSubstituteIngredientToRecipe(String recipeNodeId, String ingredientNodeId);

    @Query("MATCH (a:Allergy {nodeId:{0}}), (i:Ingredient {nodeId:{1}}) CREATE (i)-[:CAN_CAUSE]->(a)")
    public void addIngredientAllergy(String AllergyNodeId, String ingredientNodeId);

    @Query("MATCH (i:Ingredient {nodeId:{0}}), (i:Ingredient {nodeId:{1}}) CREATE (i)-[:CAN_SUBSTITUTE]->(a)")
    public void ingredientCanSubstitute(String ingredientNodeId1, String ingredientNodeId2);


    @Query("MATCH (i:Ingredient {name:{0}}) return i")
    public Ingredient getIngredientNode(String ingredientName);

    @Query("MATCH (i:Ingredient) return i")
    public List<Ingredient> getAllIngredients();
}