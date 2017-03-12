package com.recipeland.Controller;


import com.recipeland.pojo.User;
import com.recipeland.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public List<User> usuarios(){
        return (List<User>) userRepository.findAll();
    }

}
