package com.recipeland.controller;



import com.recipeland.pojo.User;
import com.recipeland.repository.UserRepository;
import com.recipeland.saver.UserSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//////////////////////////////////////////////////////////////////////////////////////
//     ******************************IMPORTANT NOTE***************************
//  Those values come from our login database, so in case of use must be created
//  a link between them for making a request of all user pojos.
//  But now is just an example of how will work this class on a live environment.
//////////////////////////////////////////////////////////////////////////////////////
@RestController
public class UserController {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserSaver usersaver;

    @RequestMapping("/createUser")
    public void createUser(String username, String email, String name, String surname){
        usersaver.userSaver(username,email,name,surname);
    }

    @RequestMapping("/createUsers")
    public void createUsers(){
    }

    @RequestMapping("/userCreatedRecipe")
    public void userCreatedRecipe(String recipeNodeId,String userNodeId){
        userRepository.userCreatedRecipe(recipeNodeId, userNodeId);
    }

    @RequestMapping("/userFavedRecipe")
    public void userFavedRecipe(HttpServletRequest request, HttpServletResponse response){
        userRepository.userFavedRecipe(request.getParameter("recipeNodeId"),request.getParameter("userNodeId")) ;
    }

    @RequestMapping("/userBlacklistedRecipe")
    public void userBlacklistedRecipe(HttpServletRequest request, HttpServletResponse response){
        userRepository.userBlacklistedRecipe(request.getParameter("recipeNodeId"),request.getParameter("userNodeId"));
    }

    @RequestMapping("/userSeeLaterRecipe")
    public void userSeeLaterRecipe(HttpServletRequest request, HttpServletResponse response){
        userRepository.userSeeLaterRecipe(request.getParameter("recipeNodeId"),request.getParameter("userNodeId"));
    }

    @RequestMapping("/getUserNode")
    public User getUserNode(String username){
        return userRepository.getUserNode(username);
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @RequestMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
