package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    final DepartmentRepository departmentRepository;



    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;

    }

    Department findByName(String departmentName){
        return departmentRepository.findByName(departmentName).orElseThrow();
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findOne(long id) {
        Optional<Department> foundDepartment = departmentRepository.findById(id);

        return foundDepartment.orElse(null);
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public void update(long id, Department updatedDepartment) {
        updatedDepartment.setId(id);
        departmentRepository.save(updatedDepartment);
    }

    public void delete(long id) {
        departmentRepository.deleteById(id);
    }


}
