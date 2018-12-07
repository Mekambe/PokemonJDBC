package com.JDBC.App.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class SpeciesDto {

    private String url;
    private String name;


    public SpeciesDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpeciesDto(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
