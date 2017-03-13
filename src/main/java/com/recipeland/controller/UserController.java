package com.recipeland.controller;


import com.recipeland.pojo.User;
import com.recipeland.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createUsers")
    public void createUsers(){
        //Creation of the data
        User marco = new User("mahernandezd","marco@recipeland.com","Marco","Antoniete");
        User joshua = new User("jgarcias","joshua@recipeland.com","Joshua","Garcilaso");
        User jose = new User("jjimenez","jose@recipeland.com","Jose","Mariana");

        //Creation of nodes using the data
        userRepository.save(marco);
        userRepository.save(joshua);
        userRepository.save(jose);

    }
    @RequestMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
