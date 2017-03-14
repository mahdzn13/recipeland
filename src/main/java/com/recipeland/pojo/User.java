package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User extends BasicNode {
    @GraphId private Long id;

    private String username;
    private String name;
    private String surname;
    private String email;

    private User() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public User(String username, String email, String name, String surname ) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
