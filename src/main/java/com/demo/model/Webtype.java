package com.demo.model;

import java.util.List;

public class Webtype {
    private Integer id;

    private String name;

    private List<Web> webs;

    public List<Web> getWebs() {
        return webs;
    }

    public void setWebs(List<Web> webs) {
        this.webs = webs;
    }

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
}