package com.partior.starwars.repository;

import com.partior.starwars.model.Starship;

import java.util.Optional;

public interface StarshipRepository {

    public Optional<Starship> getStarshipSnapshotByName(String starshipName);

    public Starship getStarshipByUrl(String url);

}
