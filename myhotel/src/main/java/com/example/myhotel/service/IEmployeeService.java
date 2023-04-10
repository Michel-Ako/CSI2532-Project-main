package com.example.myhotel.service;

import com.example.myhotel.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
    Optional<Employee> getEmployeeBynomComplet(String nom_complet);
}
