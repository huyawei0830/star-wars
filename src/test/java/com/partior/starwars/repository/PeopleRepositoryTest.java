package com.partior.starwars.repository;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.People;
import com.partior.starwars.repository.impl.PeopleRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PeopleRepositoryTest {

    @Mock
    private HttpRequester httpRequester;

    @InjectMocks
    private PeopleRepositoryImpl peopleRepository;

    private static final People TEST_PEOPLE = new People("test-name", "test-planet-url", Arrays.asList("test-starship-url"), "test-url");

    @Test
    public void testGetPeopleByUrl() {
        Mockito.when(httpRequester.processGetRequest("test-url", People.class)).thenReturn(TEST_PEOPLE);

        People result = peopleRepository.getPeopleByUrl("test-url");
        assertEquals("People not equal", new People("test-name", "test-planet-url", Arrays.asList("test-starship-url"), "test-url"), result);
    }

}
