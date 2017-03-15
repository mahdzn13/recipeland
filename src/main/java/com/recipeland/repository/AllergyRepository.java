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

    @Query("MATCH (u:User {nodeId:{0}}), (a:Allergy {nodeId:{1}}) CREATE (u)-[:IS_ALLERGIC_TO]->(a)")
    public void addAllergyToUser(String userNodeId, String allergyNodeId);

    @Query("MATCH (a:Allergy),(u:User{nodeId:{0}}) WHERE (a)<-[:IS_ALLERGIC_TO]-(u) RETURN a")
    public List<Allergy> getUserAllergies(String userNodeId);
}