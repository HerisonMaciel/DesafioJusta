package com.justa.desafio.model;

import javax.persistence.*;

@Entity
public class Feriado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String counties;
    private String launchYear;
    private String type;

    public Feriado() {

    }

    public Feriado(Long id, String date, String localName, String name, String countryCode, boolean fixed, boolean global, String counties, String launchYear, String type) {
        this.id = id;
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String getCounties() {
        return counties;
    }

    public void setCounties(String counties) {
        this.counties = counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
