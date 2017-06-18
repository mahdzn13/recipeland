package com.recipeland.controller;


import com.recipeland.pojo.Allergy;
import com.recipeland.repository.AllergyRepository;
import com.recipeland.saver.AllergySaver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/addAllergyToUser")
    public void addAllergyToUser(HttpServletRequest request, HttpServletResponse response){
        allergyRepository.addAllergyToUser(request.getParameter("userNodeId"),request.getParameter("allergyNodeId"));
    }

    @RequestMapping("/removeAllergyFromUser")
    public void removeAllergyFromUser(HttpServletRequest request, HttpServletResponse response){
        allergyRepository.removeAllergyFromUser(request.getParameter("userNodeId"),request.getParameter("allergyNodeId"));
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
    @RequestMapping("getUserAllergies")
    public List<Allergy> getUserAllergies(String userNodeId){
        return allergyRepository.getUserAllergies(userNodeId);
    }

    @RequestMapping("/deleteAllergies")
    public void deleteAllAllergys(){
        allergyRepository.deleteAll();
    }
}
