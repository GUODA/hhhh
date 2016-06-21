package com.demo.model;

public class Certification {
    private Integer id;

    private String name;

    private String description;

    private String picture;

    private Integer competdateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getCompetdateId() {
        return competdateId;
    }

    public void setCompetdateId(Integer competdateId) {
        this.competdateId = competdateId;
    }
}