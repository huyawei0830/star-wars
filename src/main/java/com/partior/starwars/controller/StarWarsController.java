package com.partior.starwars.controller;

import com.partior.starwars.dto.InformationDto;
import com.partior.starwars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private StarWarsService starWarsService;

    @Autowired
    public void setStarWarsService(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/information")
    public InformationDto getInformation() {
        return starWarsService.getInformation();
    }

}
