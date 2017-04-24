package com.recipeland.controller;

import com.recipeland.pojo.Comment;
import com.recipeland.repository.CommentRepository;
import com.recipeland.saver.CommentSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Marco on 12/04/2017.
 */
public class CommentController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentSaver commentSaver;

    //Working POST so now implement it lazy fuck
    @RequestMapping("/createComment")
    public void createComment(HttpServletRequest request, HttpServletResponse response){
        commentSaver.commentSaver(request.getParameter("commentText"));
    }

    @RequestMapping("/createComments")
    public void createComments(){
        commentSaver.commentSaver("Sausage with fries");
        commentSaver.commentSaver("Pizza Hawaii");
        commentSaver.commentSaver("Spaghetti");
    }

    @RequestMapping("/getCommentNode")
    public Comment getCommentNode(String commentName){
        return commentRepository.getCommentNode(commentName);
    }

    @RequestMapping("/getAllComments")
    public List<Comment> getAllComments(){
        return commentRepository.getAllComments();
    }
    

    @RequestMapping("/deleteComments")
    public void deleteAllComments(){
        commentRepository.deleteAll();
    }
}
