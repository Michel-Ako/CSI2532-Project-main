package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Employee;
import com.example.myhotel.repository.EmployeeRepository;
import com.example.myhotel.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setNom_complet(employee.getNom_complet());
            existingEmployee.setAdresse(employee.getAdresse());
            existingEmployee.setNas(employee.getNas());
            existingEmployee.setPoste(employee.getPoste());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmployeeBynom_complet(String nom_complet) {
        return employeeRepository.findBynom_complet(nom_complet);
    }

}
