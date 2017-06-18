package com.recipeland.saver;


import com.recipeland.pojo.User;
import com.recipeland.repository.UserRepository;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaver {
    @Autowired
    private Generator generator;

    @Autowired
    private UserRepository userRepository;

    public void userSaver(String userName, String email, String name, String surname){
        //Creation of the data
        User user = new User(userName,email,name,surname);
        System.out.println("Usersaver: " + user);
        //Create UUID
        generator.generateNodeId(user);

        //Creation of nodes using the data
        userRepository.save(user);

    }
}
