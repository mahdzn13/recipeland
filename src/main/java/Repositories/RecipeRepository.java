package Repositories;


import Pojos.Recipe;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends GraphRepository<Recipe> {
    Recipe findByName(String name);
}
