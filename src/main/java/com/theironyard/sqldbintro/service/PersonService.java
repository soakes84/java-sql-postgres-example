package com.theironyard.sqldbintro.service;

import com.theironyard.sqldbintro.model.Person;

import java.util.List;

public interface PersonService {

    void add(Person person);
    void add(List<Person> people);

    Person getById(int id);

    List<Person> get();

    void update(Person person);
    void updateFirstName(Person person);

    void delete(int id);
}