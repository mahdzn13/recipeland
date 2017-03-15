package com.recipeland.repository;



import com.recipeland.pojo.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GraphRepository<User> {
    @Query("MATCH (r:Recipe {nodeId:{0}}), (u:User {nodeId:{1}}) CREATE (u)-[:CREATED]->(r)")
    public void userCreatedRecipe(String recipeNodeId, String userNodeId);

    @Query("MATCH (r:Recipe {nodeId:{0}}), (u:User {nodeId:{1}}) CREATE (u)-[:FAVED]->(r)")
    public void userFavedRecipe(String recipeNodeId, String userNodeId);

    @Query("MATCH (r:Recipe {nodeId:{0}}), (u:User {nodeId:{1}}) CREATE (u)-[:BLACKLISTED]->(r)")
    public void userBlacklistedRecipe(String recipeNodeId, String userNodeId);

    @Query("MATCH (r:Recipe {nodeId:{0}}), (u:User {nodeId:{1}}) CREATE (u)-[:SEE_LATER]->(r)")
    public void userSeeLaterRecipe(String recipeNodeId, String userNodeId);

    @Query("MATCH (u:User {username:{0}}) RETURN u")
    public User getUserNode(String username);

    @Query("MATCH (u:User) RETURN u ORDER BY u.name DESC")
    public List<User> getAllUsers();
}
