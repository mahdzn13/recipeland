package com.recipeland.repository;



import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.recipeland.pojo.Recipe;

import java.util.List;


@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {
    @Query("MATCH (r:Recipe {name:'recipeName'}) RETURN ID(r)")
    public Recipe getRecipeId(@Param("recipeName") String recipeName);

    @Query("MATCH (r:Recipe) return r")
    public List<Recipe> getAllRecipes();
}
