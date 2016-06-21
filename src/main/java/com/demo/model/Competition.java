package com.demo.model;

public class Competition {
    private Integer id;

    private String name;

    private String description;

    private String picture;

    private String proccess;

    private Integer certificationId;

    private Integer competypeId;

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

    public String getProccess() {
        return proccess;
    }

    public void setProccess(String proccess) {
        this.proccess = proccess == null ? null : proccess.trim();
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public Integer getCompetypeId() {
        return competypeId;
    }

    public void setCompetypeId(Integer competypeId) {
        this.competypeId = competypeId;
    }
}