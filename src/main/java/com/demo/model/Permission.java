package com.demo.model;

public class Permission {
    private Integer id;

    private Integer types;

    private String resourse;

    private String operation;

    private String instance;

    private String description;

    private Boolean resourseperm;

    private Boolean systemperm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getResourse() {
        return resourse;
    }

    public void setResourse(String resourse) {
        this.resourse = resourse == null ? null : resourse.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance == null ? null : instance.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getResourseperm() {
        return resourseperm;
    }

    public void setResourseperm(Boolean resourseperm) {
        this.resourseperm = resourseperm;
    }

    public Boolean getSystemperm() {
        return systemperm;
    }

    public void setSystemperm(Boolean systemperm) {
        this.systemperm = systemperm;
    }
}