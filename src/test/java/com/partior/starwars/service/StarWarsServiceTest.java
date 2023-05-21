package com.partior.starwars.service;

import com.partior.starwars.dto.StarshipDto;
import com.partior.starwars.model.People;
import com.partior.starwars.model.Planet;
import com.partior.starwars.model.Starship;
import com.partior.starwars.repository.PeopleRepository;
import com.partior.starwars.repository.PlanetRepository;
import com.partior.starwars.repository.StarshipRepository;
import com.partior.starwars.service.impl.StarWarsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StarWarsServiceTest {

    @Mock
    private PeopleRepository peopleRepository;

    @Mock
    private PlanetRepository planetRepository;

    @Mock
    private StarshipRepository starshipRepository;

    @InjectMocks
    private StarWarsServiceImpl starWarsService;

    private static final People TEST_PEOPLE = new People("test-name", "test-planet-url", Arrays.asList("test-starship-url"), "test-url");
    private static final Starship TEST_STARSHIP = new Starship("test-starship-name", "test-class", "test-model", "test-starship-url", "123,456");
    private static final Planet TEST_PLANET = new Planet("test-planet-name", "test-planet-url");

    @Test
    public void testGetStarshipOf() {
        Mockito.when(peopleRepository.getPeopleSnapshotByName("test-name")).thenReturn(Optional.of(TEST_PEOPLE));
        Mockito.when(peopleRepository.getPeopleByUrl("test-url")).thenReturn(TEST_PEOPLE);
        Mockito.when(starshipRepository.getStarshipByUrl("test-starship-url")).thenReturn(TEST_STARSHIP);

        StarshipDto result = starWarsService.getStarshipOf("test-name");
        assertEquals("StarshipDto not equal", new StarshipDto("test-starship-name", "test-class", "test-model"), result);
    }

    @Test
    public void testGetCrewOnStarship() {
        Mockito.when(starshipRepository.getStarshipSnapshotByName("test-starship-name")).thenReturn(Optional.of(TEST_STARSHIP));
        Mockito.when(starshipRepository.getStarshipByUrl("test-starship-url")).thenReturn(TEST_STARSHIP);

        int result = starWarsService.getCrewOnStarship("test-starship-name");
        assertEquals("Unexpected crew number", 123456, result);
    }

    @Test
    public void testCheckIfPeopleOnPlanet() {
        Mockito.when(peopleRepository.getPeopleSnapshotByName("test-name")).thenReturn(Optional.of(TEST_PEOPLE));
        Mockito.when(peopleRepository.getPeopleByUrl("test-url")).thenReturn(TEST_PEOPLE);
        Mockito.when(planetRepository.getPlanetByUrl("test-planet-url")).thenReturn(TEST_PLANET);

        boolean result = starWarsService.checkIfPeopleOnPlanet("test-name", "test-planet-name");
        assertEquals("Unexpected result", true, result);
    }

}
