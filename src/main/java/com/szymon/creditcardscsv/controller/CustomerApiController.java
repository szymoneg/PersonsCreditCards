package com.szymon.creditcardscsv.controller;

import com.szymon.creditcardscsv.domain.dao.Person;
import com.szymon.creditcardscsv.domain.dto.PersonRequest;
import com.szymon.creditcardscsv.service.PersonService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CustomerApiController {
    final PersonService personService;

    public CustomerApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/server-test")
    public String test(){
        return "server ok!";
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.getAll();
    }

    @PostMapping("/persons/new")
    public ResponseEntity<?> addNewPerson(@RequestBody PersonRequest personRequest){
        personService.create(personRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //TODO next method
}
