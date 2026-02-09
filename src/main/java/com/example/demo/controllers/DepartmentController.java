package com.example.demo.controllers;


import com.example.demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class DepartmentController {
    final DepartmentService departmentService;

}
