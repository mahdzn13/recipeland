package com.recipeland.controller;

import com.recipeland.pojo.Comment;
import com.recipeland.repository.CommentRepository;
import com.recipeland.saver.CommentSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentSaver commentSaver;

    @RequestMapping("/createComment")
    public void createComment(HttpServletRequest request, HttpServletResponse response){
        commentSaver.commentSaver(request.getParameter("commentText"));
        String commentNodeId = commentRepository.getCommentNode(request.getParameter("commentText")).getNodeId();

        commentRepository.addCommentToUser(commentNodeId,request.getParameter("userNodeId"));
        commentRepository.addCommentToRecipe(commentNodeId,request.getParameter("recipeNodeId"));
    }

    @RequestMapping("/createComments")
    public void createComments(){

    }

    @RequestMapping("/getAllCommentsFromRecipe")
    public List<Comment> getAllComments(){
        return commentRepository.getAllCommentsFromRecipe();
    }
    

    @RequestMapping("/deleteComments")
    public void deleteAllComments(){
        commentRepository.deleteAll();
    }
}
