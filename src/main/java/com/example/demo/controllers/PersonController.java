package com.example.demo.controllers;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonServiceImplementation;
import com.example.demo.service.ServiceMariaDb;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonController {
    final PersonServiceImplementation personServiceImplementation;

    @GetMapping("/findById/{id}")
    public Person findPersonById(@PathVariable Long id) {
        return personServiceImplementation.findPersonById(id);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        personServiceImplementation.createPerson(person);
    }

    @GetMapping("/findByName")
    public Person findPersonByUsername(@RequestParam String username) {
       return personServiceImplementation.findByUsername(username);
    }





}
