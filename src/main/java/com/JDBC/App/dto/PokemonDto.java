package com.JDBC.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties (ignoreUnknown = true) // ignore all other fields
public class PokemonDto {

private String name;
private int weight;
private SpeciesDto species;


    public PokemonDto() {
    }

    public PokemonDto(String name, String valueOf, SpeciesDto species) {

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

    public SpeciesDto getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDto species) {
        this.species = species;
    }

    public PokemonDto(String name, int weight, SpeciesDto species) {
        this.name = name;
        this.weight = weight;
        this.species = species;
    }
}
