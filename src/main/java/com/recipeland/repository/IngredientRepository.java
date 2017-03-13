package com.recipeland.repository;

import com.recipeland.pojo.Ingredient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends GraphRepository<Ingredient> {
    //@Query("MATCH (r:Recipe {id:'recipeName'}), (i:Ingredient {id:'ingredientName'}) CREATE (i)-[:PART_OF]->(r)")
    @Query("MATCH (i:Ingredient), (r:Recipe) WHERE ID(i) = iID AND ID(r) = rID CREATE (i)-[:PART_OF]->(r);")
    public void addIngredientToRecipe(@Param("rID") Long rID, @Param("iID") Long iID);

    @Query("MATCH (i:Ingredient {name:'ingredientName'}) RETURN ID(i)")
    public Ingredient getIngredientId(@Param("ingredientName") String ingredientName);
}
