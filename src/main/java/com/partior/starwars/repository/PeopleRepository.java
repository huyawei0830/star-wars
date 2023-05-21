package com.partior.starwars.repository;

import com.partior.starwars.model.People;

import java.util.Optional;

public interface PeopleRepository {

    public Optional<People> getPeopleSnapshotByName(String peopleName);

    public People getPeopleByUrl(String url);

}
