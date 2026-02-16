package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.entity.Person;


import java.util.List;
import java.util.Optional;

public interface PersonService {
    public void createPerson(Person person);
    public Person findPersonById(Long id) throws InterruptedException;
    public Person findByUsername(String username);

    public List<Person> findByDepartment(Department department);

    public List<Person> findAll();
    public void update(long id, Person updatedPerson);
    public void delete(long id);

    Optional<Person>findById(long id);
}
