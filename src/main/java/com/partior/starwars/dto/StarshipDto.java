package com.partior.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StarshipDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private String starshipClass;

    @JsonProperty("model")
    private String model;

    public StarshipDto() {
    }

    public StarshipDto(String name, String starshipClass, String model) {
        this.name = name;
        this.starshipClass = starshipClass;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
