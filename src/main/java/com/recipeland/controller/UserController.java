package com.recipeland.controller;



import com.recipeland.pojo.User;
import com.recipeland.repository.UserRepository;
import com.recipeland.saver.UserSaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        usersaver.userSaver("mahernandezd","marco@recipeland.com","Marco","Antoniete");
        usersaver.userSaver("jgarcias","joshua@recipeland.com","Joshua","Garcilaso");
        usersaver.userSaver("jjimenez","jose@recipeland.com","Jose","Mariana");
    }

    @RequestMapping("/userCreatedRecipe")
    public void userCreatedRecipe(String recipeNodeId,String userNodeId){
        userRepository.userCreatedRecipe(recipeNodeId, userNodeId);
    }

    @RequestMapping("/userFavedRecipe")
    public void userFavedRecipe(String recipeNodeId,String userNodeId){
        userRepository.userFavedRecipe(recipeNodeId, userNodeId);
    }

    @RequestMapping("/userBlacklistedRecipe")
    public void userBlacklistedRecipe(String recipeNodeId,String userNodeId){
        userRepository.userBlacklistedRecipe(recipeNodeId, userNodeId);
    }

    @RequestMapping("/userSeeLaterRecipe")
    public void userSeeLaterRecipe(String recipeNodeId,String userNodeId){
        userRepository.userSeeLaterRecipe(recipeNodeId, userNodeId);
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
