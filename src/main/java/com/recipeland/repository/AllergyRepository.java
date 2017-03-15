package com.recipeland.repository;

import com.recipeland.pojo.Allergy;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends GraphRepository<Allergy> {

    @Query("MATCH (a:Allergy {name:{0}}) RETURN a")
    public Allergy getAllergyNode(String allergyName);

    @Query("MATCH (a:Allergy) return a ORDER BY a.name DESC")
    public List<Allergy> getAllAllergies();
}