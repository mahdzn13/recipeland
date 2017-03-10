package com.esliceu.dwes.marco.repository;



import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import com.esliceu.dwes.marco.pojo.Recipe;

@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {
    Recipe findByName(String name);
}
