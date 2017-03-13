package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Allergy {
    @GraphId private Long id;

    private String name;
    private String description;

    private Allergy() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Allergy(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

