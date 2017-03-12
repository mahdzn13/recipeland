package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {
    @GraphId private Long id;

    private String username;
    private String name;
    private String email;


    private User() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public User(String name) {
        this.name = name;
    }

    public User(String username, String name, String email ) {
        this.username = username;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
