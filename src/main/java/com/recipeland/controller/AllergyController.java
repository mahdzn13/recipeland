package com.recipeland.controller;


import com.recipeland.pojo.Allergy;
import com.recipeland.repository.AllergyRepository;
import com.recipeland.saver.AllergySaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AllergyController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private AllergyRepository allergyRepository;

    @Autowired
    private AllergySaver allergySaver;

    @RequestMapping("/createAllergy")
    public void createAllergy(String allergyName, String allergyDescription){
        allergySaver.allergySaver(allergyName,allergyDescription);
    }

    @RequestMapping("/createAllergies")
    public void createAllergies(){
        allergySaver.allergySaver("Allergy1","desc1");
        allergySaver.allergySaver("Allergy2","desc2");
        allergySaver.allergySaver("Allergy2","desc3");
    }

    @RequestMapping("/getAllergyNode")
    public Allergy getAllergyNode(String allergyName){
        return allergyRepository.getAllergyNode(allergyName);
    }

    @RequestMapping("/getAllAllergies")
    public List<Allergy> getAllAllergies(){
        return allergyRepository.getAllAllergies();
    }

    @RequestMapping("/deleteAllergies")
    public void deleteAllAllergys(){
        allergyRepository.deleteAll();
    }
}
