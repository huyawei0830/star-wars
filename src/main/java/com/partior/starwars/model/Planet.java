package com.partior.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Some fields were omitted
 */
public class Planet implements Serializable {

    @Serial
    private static final long serialVersionUID = 8819817190203234782L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    public Planet() {
    }

    public Planet(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) && Objects.equals(url, planet.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

}
