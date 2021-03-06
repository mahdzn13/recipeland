package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Ingredient extends BasicNode{
    @GraphId private Long id;

    private String name;


    private Ingredient() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Ingredient(String name) {
        this.name = name;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
