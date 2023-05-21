package com.partior.starwars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StarshipDto that = (StarshipDto) o;
        return Objects.equals(name, that.name) && Objects.equals(starshipClass, that.starshipClass) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, starshipClass, model);
    }

}
