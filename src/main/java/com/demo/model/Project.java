package com.demo.model;

public class Project {
    private Integer id;

    private String name;

    private String description;

    private String teacher;

    private String picture;

    private Integer projecttypeId;

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getProjecttypeId() {
        return projecttypeId;
    }

    public void setProjecttypeId(Integer projecttypeId) {
        this.projecttypeId = projecttypeId;
    }
}