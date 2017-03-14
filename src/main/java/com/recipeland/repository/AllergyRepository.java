package com.recipeland.repository;

import com.recipeland.pojo.Allergy;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends GraphRepository<Allergy> {

    @Query("MATCH (a:Allergy {name:'allergyName'}) RETURN ID(a)")
    public Allergy getAllergyId(@Param("allergyName") String allergyName);

    @Query("MATCH (a:Allergy) return a")
    public List<Allergy> getAllAllergies();
}