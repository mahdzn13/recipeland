package com.recipeland.repository;

import com.recipeland.pojo.Comment;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends GraphRepository<Comment> {

    @Query("MATCH (c:Comment)-[:IS_POSTED_ON]->(r:Recipe {nodeId:{0}}) return c")
    public List<Comment> getAllCommentsFromRecipe(String recipeNodeId);

    @Query("MATCH (c:Comment)-[:IS_POSTED_ON]->(r:Recipe {nodeId:{0}}) return count(c)")
    public int getAllCountOfCommentsFromRecipe(String recipeNodeId);

    @Query("MATCH (c:Comment {text:{0}}) RETURN c")
    public Comment getCommentNode(String text);

    @Query("MATCH (c:Comment {nodeId:{0}}), (u:User {nodeId:{1}}) CREATE (u)-[:COMMENTED]->(c)")
    public List<Comment> addCommentToUser(String commentNodeId, String userNodeId);

    @Query("MATCH (c:Comment {nodeId:{0}}), (r:Recipe {nodeId:{1}}) CREATE (c)-[:IS_POSTED_ON]->(r)")
    public List<Comment> addCommentToRecipe(String commentNodeId, String recipeNodeId);
}