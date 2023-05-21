package com.partior.starwars.controller;

import com.partior.starwars.dto.InformationDto;
import com.partior.starwars.dto.StarshipDto;
import com.partior.starwars.service.StarWarsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
public class StarWarsControllerTest {

    @Mock
    private StarWarsService starWarsService;

    @InjectMocks
    private StarWarsController starWarsController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(starWarsController).build();
    }

    @Test
    public void testGetInformation() throws Exception {
        InformationDto informationDto = new InformationDto(
                new StarshipDto("test-name", "test-class", "test-model"),
                123,
                true
        );
        Mockito.when(starWarsService.getInformation()).thenReturn(informationDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/information"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("starship.name").value("test-name"))
                .andExpect(MockMvcResultMatchers.jsonPath("starship.class").value("test-class"))
                .andExpect(MockMvcResultMatchers.jsonPath("starship.model").value("test-model"))
                .andExpect(MockMvcResultMatchers.jsonPath("crew").value(123))
                .andExpect(MockMvcResultMatchers.jsonPath("isLeiaOnPlanet").value(true));
    }

}