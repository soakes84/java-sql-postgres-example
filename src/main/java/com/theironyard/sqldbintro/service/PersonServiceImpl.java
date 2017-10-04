package com.theironyard.sqldbintro.service;

import com.theironyard.sqldbintro.model.Person;
import com.theironyard.sqldbintro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    @Override
    public void add(Person person) {
        personRepository.add(person);
    }

    @Transactional
    @Override
    public void add(List<Person> people) {
        for(Person person : people) {
            personRepository.add(person);
        }

    }

    @Override
    public Person getById(int id) {
        return personRepository.getById(id);
    }

    @Override
    public List<Person> get() {
        return personRepository.get();
    }

    @Transactional
    @Override
    public void update(Person person) {
        personRepository.update(person);
    }

    @Transactional
    @Override
    public void updateFirstName(Person person) {
        personRepository.updateFirstName(person);
    }

    @Transactional
    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }
}
