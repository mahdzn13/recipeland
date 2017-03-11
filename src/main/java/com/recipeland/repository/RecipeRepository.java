package com.recipeland.repository;



import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import com.recipeland.pojo.Recipe;

@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {
    Recipe findByName(String name);
}
