package com.partior.starwars.repository;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.Starship;
import com.partior.starwars.repository.impl.StarshipRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StarshipRepositoryTest {

    @Mock
    private HttpRequester httpRequester;

    @InjectMocks
    private StarshipRepositoryImpl starshipRepository;

    private static final Starship TEST_STARSHIP = new Starship("test-starship-name", "test-class", "test-model", "test-starship-url", "123,456");

    @Test
    public void testGetStarshipByUrl() {
        Mockito.when(httpRequester.processGetRequest("test-starship-url", Starship.class)).thenReturn(TEST_STARSHIP);

        Starship result = starshipRepository.getStarshipByUrl("test-starship-url");
        assertEquals("Starship not equal", new Starship("test-starship-name", "test-class", "test-model", "test-starship-url", "123,456"), result);
    }

}
