package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;


    public Person() {
    }

    public Person(String username, String password, int age, Department department) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.department = department;
    }
}
