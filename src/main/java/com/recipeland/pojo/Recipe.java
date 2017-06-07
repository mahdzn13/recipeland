package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Recipe extends BasicNode {
    @GraphId private Long id;

    private String name;
    private String image;
    private String recipeText;

    private Recipe() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Recipe(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Recipe(String name, String image, String recipeText) {
        this.name = name;
        this.image = image;
        this.recipeText = recipeText;
    }



    public String toString() {
        return this.name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }
}

