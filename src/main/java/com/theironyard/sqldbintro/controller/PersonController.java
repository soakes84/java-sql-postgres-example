package com.theironyard.sqldbintro.controller;


import com.theironyard.sqldbintro.model.Person;
import com.theironyard.sqldbintro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(path = "/api/people", method = RequestMethod.GET)
    public List<Person> getPeople() {
        List<Person> people = personService.get();

        return people;
    }

    @RequestMapping(path = "/api/people/{personId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("personId") int personId) {
        Person person = personService.getById(personId);

        return person;
    }


    @RequestMapping(path = "/api/people", method = RequestMethod.POST)
    public void addPerson(@RequestParam String firstName, @RequestParam String lastName){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        personService.add(person);
    }

    @RequestMapping(path = "/api/people/{id}", method = RequestMethod.PUT)
    public void updatePerson(@PathVariable("id") String id, @RequestParam String firstName, @RequestParam String lastName) {
        int personId = Integer.parseInt(id);
        Person person = personService.getById(personId);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        personService.update(person);
    }

    @RequestMapping(path = "/api/people/{personId", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("personId") int personId) {
        personService.delete(personId);
    }

}
