package com.recipeland.saver;

import com.recipeland.pojo.Comment;
import com.recipeland.repository.CommentRepository;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentSaver {
    @Autowired
    private Generator generator;

    @Autowired
    private CommentRepository ingredientRepository;

    public void commentSaver(String commentText){
        //Creation of the data
        Comment comment = new Comment(commentText);

        //Create UUID
        generator.generateNodeId(comment);

        //Creation of nodes using the data
        ingredientRepository.save(comment);
    }
}