package com.bridgelabz.employeepayroll.service;



import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        log.info("Fetching all employees from database");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found."));
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO){
        log.info("Saving new employee: {}", employeeDTO);
        Employee employee = mapDtoToEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        log.info("Updating employee with ID: {}", id);
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(updatedEmployeeDTO.getName());
        existingEmployee.setSalary(updatedEmployeeDTO.getSalary());
        existingEmployee.setGender(updatedEmployeeDTO.getGender());
        existingEmployee.setStartDate(updatedEmployeeDTO.getStartDate());
        existingEmployee.setNote(updatedEmployeeDTO.getNote());
        existingEmployee.setProfilePic(updatedEmployeeDTO.getProfilePic());
        existingEmployee.setDepartment(updatedEmployeeDTO.getDepartment());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }

    private Employee mapDtoToEntity(EmployeeDTO employeeDTO) {
        return new Employee(
                null,
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getGender(),
                employeeDTO.getStartDate(),
                employeeDTO.getNote(),
                employeeDTO.getProfilePic(),
                employeeDTO.getDepartment()
        );
    }
}

