package com.recipeland.utils;

import com.recipeland.pojo.BasicNode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Generator {

    public void generateNodeId(BasicNode basicNode){
        basicNode.setNodeId(UUID.randomUUID().toString());
    }

}
