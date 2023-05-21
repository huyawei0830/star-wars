package com.partior.starwars.repository.impl;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.Planet;
import com.partior.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlanetRepositoryImpl implements PlanetRepository {

    private HttpRequester httpRequester;

    public PlanetRepositoryImpl() {}

    @Autowired
    public void setHttpRequester(HttpRequester httpRequester) {
        this.httpRequester = httpRequester;
    }

    @Override
    public Planet getPlanetByUrl(String url) {
        return httpRequester.processGetRequest(url, Planet.class);
    }

}
