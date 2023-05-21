package com.partior.starwars.service;

import com.partior.starwars.dto.InformationDto;
import com.partior.starwars.dto.StarshipDto;

public interface StarWarsService {

    public InformationDto getInformation();

    public StarshipDto getStarshipOf(String peopleName);

    public int getCrewOnStarship(String starshipName);

    public boolean checkIfPeopleOnPlanet(String peopleName, String planetName);

}
