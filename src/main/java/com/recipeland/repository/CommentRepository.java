package com.recipeland.repository;

import com.recipeland.pojo.Comment;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends GraphRepository<Comment> {

    @Query("MATCH (a:Comment {name:{0}}) RETURN a")
    public Comment getCommentNode(String allergyName);

    @Query("MATCH (a:Comment) return a ORDER BY a.name DESC")
    public List<Comment> getAllComments();

}