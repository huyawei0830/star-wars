package com.partior.starwars.service.impl;

import com.partior.starwars.dto.InformationDto;
import com.partior.starwars.dto.StarshipDto;
import com.partior.starwars.model.People;
import com.partior.starwars.model.Planet;
import com.partior.starwars.model.Starship;
import com.partior.starwars.repository.PeopleRepository;
import com.partior.starwars.repository.PlanetRepository;
import com.partior.starwars.repository.StarshipRepository;
import com.partior.starwars.service.StarWarsService;
import com.partior.starwars.util.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    private static final String PEOPLE_DARTH_VADER_NAME = "Darth Vader";
    private static final String PEOPLE_LEILA_ORGANA_NAME = "Leia Organa";
    private static final String STARSHIP_DEATH_STAR_NAME = "Death Star";
    private static final String PLANET_ALDERAAN_NAME = "Alderaan";

    private PeopleRepository peopleRepository;
    private PlanetRepository planetRepository;
    private StarshipRepository starshipRepository;

    @Autowired
    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Autowired
    public void setPlanetRepository(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Autowired
    public void setStarshipRepository(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    @Override
    public InformationDto getInformation() {
        return new InformationDto(
                getStarshipOf(PEOPLE_DARTH_VADER_NAME),
                getCrewOnStarship(STARSHIP_DEATH_STAR_NAME),
                checkIfPeopleOnPlanet(PEOPLE_LEILA_ORGANA_NAME, PLANET_ALDERAAN_NAME)
        );
    }

    private StarshipDto getStarshipOf(String peopleName) {
        Optional<People> peopleSnapshot = peopleRepository.getPeopleSnapshotByName(peopleName);
        String peopleUrl = peopleSnapshot.map(d -> d.getUrl()).orElseThrow(() -> new RuntimeException(peopleName + "not found"));
        List<String> starships = peopleRepository.getPeopleByUrl(peopleUrl).getStarships();
        if (CollectionUtils.isEmpty(starships)) {
            return new StarshipDto();
        } else {
            // If the person has multiple starships, get the 1st one
            return starshipRepository.getStarshipByUrl(starships.get(0)).toDto();
        }
    }

    private int getCrewOnStarship(String starshipName) {
        Optional<Starship> starshipSnapshot = starshipRepository.getStarshipSnapshotByName(starshipName);
        String starshipUrl = starshipSnapshot.map(s -> s.getUrl()).orElseThrow(() -> new RuntimeException(starshipName + "not found"));
        Starship starship = starshipRepository.getStarshipByUrl(starshipUrl);
        return ConversionUtil.stringToInt(starship.getCrew());
    }

    private boolean checkIfPeopleOnPlanet(String peopleName, String planetName) {
        Optional<People> peopleSnapshot = peopleRepository.getPeopleSnapshotByName(peopleName);
        String peopleUrl = peopleSnapshot.map(d -> d.getUrl()).orElseThrow(() -> new RuntimeException(peopleName + "not found"));
        String planetUrl = peopleRepository.getPeopleByUrl(peopleUrl).getHomeworld();
        Planet planet = planetRepository.getPlanetByUrl(planetUrl);
        return planetName.equals(planet.getName());
    }

}
