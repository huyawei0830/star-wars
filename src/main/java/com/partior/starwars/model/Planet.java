package com.partior.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class Planet implements Serializable {

    @Serial
    private static final long serialVersionUID = 8819817190203234782L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

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

}
