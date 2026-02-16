package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);

    List<Person> findByDepartment(Department department);  // получим всех людей для этого Департамента

    @Query("SELECT p FROM Person p JOIN FETCH p.department WHERE p.id = :id" )
    Optional<Person>findById(@Param("id") long id);

    @Query(value = "Select * from Person p where name ILIKE :startWith%", nativeQuery = true)
    List<Person> findPersonByNameStartingWith(@Param("startWith") String startWith);
    @Query(value = "SELECT p FROM Person p WHERE LOWER (p.username) LIKE LOWER (CONCAT(:startWith, '%'))")
    List<Person> findPersonByNameStartsWith(@Param("startWith") String startWith);

}
