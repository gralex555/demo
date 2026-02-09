package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Person;
import com.example.demo.service.impl.PersonService;

import java.util.List;

public class ServiceMariaDb implements PersonService {

    @Override
    public void createPerson(Person person) {

    }

    @Override
    public Person findPersonById(Long id) {
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        return null;
    }

    @Override
    public List<Person> findByDepartment(Department department) {
        return List.of();
    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public void update(long id, Person updatedPerson) {

    }

    @Override
    public void delete(long id) {

    }
}
