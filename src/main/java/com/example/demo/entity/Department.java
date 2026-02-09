package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Department {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Person> personList;


    public Department(){}

    public Department(String name, List<Person> personList) {
        this.name = name;
        this.personList = personList;
    }
}
