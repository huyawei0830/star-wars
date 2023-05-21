package com.partior.starwars.repository;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.Planet;
import com.partior.starwars.repository.impl.PlanetRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PlanetRepositoryTest {

    @Mock
    private HttpRequester httpRequester;

    @InjectMocks
    private PlanetRepositoryImpl planetRepository;

    private static final Planet TEST_PLANET = new Planet("test-planet-name", "test-planet-url");

    @Test
    public void testGetPlanetByUrl() {
        Mockito.when(httpRequester.processGetRequest("test-planet-url", Planet.class)).thenReturn(TEST_PLANET);

        Planet result = planetRepository.getPlanetByUrl("test-planet-url");
        assertEquals("Planet not equal", new Planet("test-planet-name", "test-planet-url"), result);
    }

}
