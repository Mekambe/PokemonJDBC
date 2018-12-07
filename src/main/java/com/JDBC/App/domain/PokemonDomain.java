package com.JDBC.App.domain;

import com.JDBC.App.dto.SpeciesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PokemonDomain {

    private String name;
    private int weight;
    private String speciesUrl;
    private String speciesName;

    public PokemonDomain(String name, int weight, String speciesUrl, String speciesName) {
        this.name = name;
        this.weight = weight;
        this.speciesUrl = speciesUrl;
        this.speciesName = speciesName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    public String getSpeciesUrl() {
        return speciesUrl;
    }

    public void setSpeciesUrl(String speciesUrl) {
        this.speciesUrl = speciesUrl;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public PokemonDomain() {
    }
}
