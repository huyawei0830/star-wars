package com.partior.starwars.repository.impl;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.GetStarshipsResponse;
import com.partior.starwars.model.Starship;
import com.partior.starwars.repository.StarshipRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Initialize the cache for name to entity mapping for efficient query with name
 * Query the other attributes with the url assuming they might be subjective to changes anytime
 */
@Repository
public class StarshipRepositoryImpl implements StarshipRepository {

    Logger logger = LogManager.getLogger(PeopleRepositoryImpl.class);

    private Map<String, Starship> starShipMap;

    private String baseUrl;

    private HttpRequester httpRequester;

    public StarshipRepositoryImpl() {
        starShipMap = new HashMap<>();
    }

    @PostConstruct
    private void postConstruct() {
        initializeStarshipMap();
    }

    @Value("${starwarsapi.base-url}")
    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Autowired
    public void setHttpRequester(HttpRequester httpRequester) {
        this.httpRequester = httpRequester;
    }

    private void initializeStarshipMap() {
        logger.info("Initializing starship map...");
        String url = baseUrl + "/starships";
        while (url != null) {
            GetStarshipsResponse response = httpRequester.processGetRequest(url, GetStarshipsResponse.class);
            if (!CollectionUtils.isEmpty(response.getResults())) {
                response.getResults().forEach(s -> starShipMap.put(s.getName(), s));
            }
            url = response.getNext();
        }
        logger.info("Starship map initialization is completed!");
    }

    @Override
    public Optional<Starship> getStarshipSnapshotByName(String starshipName) {
        return Optional.of(starShipMap.get(starshipName));
    }

    @Override
    public Starship getStarshipByUrl(String url) {
        return httpRequester.processGetRequest(url, Starship.class);
    }

}
