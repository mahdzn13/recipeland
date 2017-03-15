package com.recipeland.saver;


import com.recipeland.pojo.Allergy;
import com.recipeland.repository.AllergyRepository;
import com.recipeland.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllergySaver {
    @Autowired
    private Generator generator;

    @Autowired
    private AllergyRepository allergyRepository;

    public void allergySaver(String allergyName,String description){
        //Creation of the data
        Allergy allergy = new Allergy(allergyName,description);

        //Create UUID
        generator.generateNodeId(allergy);

        //Creation of nodes using the data
        allergyRepository.save(allergy);
    }
}