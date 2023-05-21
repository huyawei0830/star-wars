package com.partior.starwars.repository.impl;

import com.partior.starwars.http.HttpRequester;
import com.partior.starwars.model.GetPeopleResponse;
import com.partior.starwars.model.People;
import com.partior.starwars.repository.PeopleRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    Logger logger = LogManager.getLogger(PeopleRepositoryImpl.class);

    private Map<String, People> peopleMap;

    private String baseUrl;

    private HttpRequester httpRequester;

    public PeopleRepositoryImpl() {
        peopleMap = new HashMap<>();
    }

    @PostConstruct
    private void postConstruct() {
        initializePeopleMap();
    }

    @Value("${starwarsapi.base-url}")
    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Autowired
    public void setHttpRequester(HttpRequester httpRequester) {
        this.httpRequester = httpRequester;
    }

    private void initializePeopleMap() {
        logger.info("Initializing people map...");
        String url = baseUrl + "/people";
        while (url != null) {
            GetPeopleResponse response = httpRequester.processGetRequest(url, GetPeopleResponse.class);
            if (!CollectionUtils.isEmpty(response.getResults())) {
                response.getResults().forEach(s -> peopleMap.put(s.getName(), s));
            }
            url = response.getNext();
        }
        logger.info("People map initialization is completed!");
    }

    @Override
    public Optional<People> getPeopleSnapshotByName(String PeopleName) {
        return Optional.of(peopleMap.get(PeopleName));
    }

    @Override
    public People getPeopleByUrl(String url) {
        return httpRequester.processGetRequest(url, People.class);
    }

}
