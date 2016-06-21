package com.demo.model;

import java.util.Date;

public class Device {
    private Integer id;

    private String name;

    private String sncode;

    private Date madetime;

    private String brand;

    private String version;

    private Integer devicetypeId;

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

    public String getSncode() {
        return sncode;
    }

    public void setSncode(String sncode) {
        this.sncode = sncode == null ? null : sncode.trim();
    }

    public Date getMadetime() {
        return madetime;
    }

    public void setMadetime(Date madetime) {
        this.madetime = madetime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getDevicetypeId() {
        return devicetypeId;
    }

    public void setDevicetypeId(Integer devicetypeId) {
        this.devicetypeId = devicetypeId;
    }
}