package com.recipeland.pojo;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

@NodeEntity
public class Comment extends BasicNode{
    @GraphId private Long id;

    private String text;
    private Date createdOn = new Date();
    private Date lastTimeModified;


    private Comment() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Comment(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastTimeModified() {
        return lastTimeModified;
    }

    public void setLastTimeModified(Date lastTimeModified) {
        this.lastTimeModified = lastTimeModified;
    }
}
