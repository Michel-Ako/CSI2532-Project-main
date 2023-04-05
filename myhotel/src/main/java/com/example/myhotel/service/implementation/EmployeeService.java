package com.example.myhotel.service.implementation;
import com.example.myhotel.model.Clients;
import com.example.myhotel.repository.EmployeeRepository;
import com.example.myhotel.service.IEmployeeService;

import com.example.myhotel.model.Employee;
import com.example.myhotel.repository.EmployeeRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long ID) {
        return employeeRepository.findById(ID).orElse(null);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee findBySSN(int SSN) {
        return employeeRepository.findBySSN(SSN);
    }
    @Override
    public List<Employee> findByHotelID(@Param("Hotel_ID") long hotelID){
        return employeeRepository.findByHotelID(hotelID);
    }

    @Override
    public void changePost(Long ID, String post) {
        Employee employee = employeeRepository.findById(ID).orElse(null);
        if (employee != null) {
            employee.setPost(post);
            employeeRepository.save(employee);
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        return employeeIterable != null ? (List<Employee>) employeeIterable : new ArrayList<>();
    }
}
