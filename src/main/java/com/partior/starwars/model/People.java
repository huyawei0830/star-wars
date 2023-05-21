package com.partior.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class People implements Serializable {

    @Serial
    private static final long serialVersionUID = 3534031429227795304L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("url")
    private String url;

    public People() {
    }

    public People(String name, String homeworld, List<String> starships, String url) {
        this.name = name;
        this.homeworld = homeworld;
        this.starships = starships;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) && Objects.equals(homeworld, people.homeworld) && Objects.equals(starships, people.starships) && Objects.equals(url, people.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, homeworld, starships, url);
    }
    
}
