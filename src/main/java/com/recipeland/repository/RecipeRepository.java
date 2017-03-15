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
}
