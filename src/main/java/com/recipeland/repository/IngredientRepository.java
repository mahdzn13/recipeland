package com.recipeland.repository;

import com.recipeland.pojo.Ingredient;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends GraphRepository<Ingredient> {

}
