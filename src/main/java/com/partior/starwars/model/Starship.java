package com.partior.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.partior.starwars.dto.StarshipDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Some fields were omitted
 */
public class Starship implements Serializable {

    @Serial
    private static final long serialVersionUID = -5641405546694368857L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("model")
    private String model;

    @JsonProperty("url")
    private String url;

    @JsonProperty("crew")
    private String crew;

    public Starship() {
    }

    public Starship(String name, String starshipClass, String model, String url, String crew) {
        this.name = name;
        this.starshipClass = starshipClass;
        this.model = model;
        this.url = url;
        this.crew = crew;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public StarshipDto toDto() {
        return new StarshipDto(name, starshipClass, model);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starship starship = (Starship) o;
        return Objects.equals(name, starship.name) && Objects.equals(starshipClass, starship.starshipClass) && Objects.equals(model, starship.model) && Objects.equals(url, starship.url) && Objects.equals(crew, starship.crew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, starshipClass, model, url, crew);
    }

}
