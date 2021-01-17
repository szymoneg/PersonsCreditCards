package com.szymon.creditcardscsv.controller;

import com.szymon.creditcardscsv.domain.dao.Person;
import com.szymon.creditcardscsv.domain.dto.PersonEditRequest;
import com.szymon.creditcardscsv.domain.dto.PersonRequest;
import com.szymon.creditcardscsv.service.PersonService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
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

    @PostMapping("/persons/edit/{id}")
    public ResponseEntity<?> editPersonSubmit(@RequestBody PersonEditRequest personEditRequest, @PathVariable("id") int id){
        Optional<Person> optionalPerson = personService.getById(id);
        if (optionalPerson.isPresent()){
            personService.update(id,personEditRequest);
            return new ResponseEntity<>("Zmieniono", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Nie zmieniono", HttpStatus.BAD_REQUEST);
        }
    }

    //TODO next method
}
