package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String departmentName);

    @Query(value = "Select d from Department d where departmentName ILIKE :startWith%", nativeQuery = true)
    List<Department> findByNameStartingWith(@Param("startWith") String startWith);

}
