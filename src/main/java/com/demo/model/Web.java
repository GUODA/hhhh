package com.demo.model;

public class Web {
    private Integer id;

    private String name;

    private String url;

    private String description;

    private Integer webtypeId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getWebtypeId() {
        return webtypeId;
    }

    public void setWebtypeId(Integer webtypeId) {
        this.webtypeId = webtypeId;
    }
}