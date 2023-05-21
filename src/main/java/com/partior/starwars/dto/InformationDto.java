package com.partior.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InformationDto {

    @JsonProperty("starship")
    private StarshipDto starship;

    @JsonProperty("crew")
    private int crew;

    @JsonProperty("isLeiaOnPlanet")
    private boolean leiaOnPlanet;

    public InformationDto() {
    }

    public InformationDto(StarshipDto starship, int crew, boolean leiaOnPlanet) {
        this.starship = starship;
        this.crew = crew;
        this.leiaOnPlanet = leiaOnPlanet;
    }

    public StarshipDto getStarship() {
        return starship;
    }

    public void setStarship(StarshipDto starship) {
        this.starship = starship;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public boolean isLeiaOnPlanet() {
        return leiaOnPlanet;
    }

    public void setLeiaOnPlanet(boolean leiaOnPlanet) {
        this.leiaOnPlanet = leiaOnPlanet;
    }

}
