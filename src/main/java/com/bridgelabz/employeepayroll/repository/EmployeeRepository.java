package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE :department MEMBER OF e.department")
    List<Employee> findEmployeesByDepartment(String department);
}

