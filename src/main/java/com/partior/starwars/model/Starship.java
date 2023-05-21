package com.partior.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.partior.starwars.dto.StarshipDto;

import java.io.Serial;
import java.io.Serializable;

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

}
