package com.partior.starwars.repository;

import com.partior.starwars.model.Planet;

public interface PlanetRepository {

    public Planet getPlanetByUrl(String url);

}
