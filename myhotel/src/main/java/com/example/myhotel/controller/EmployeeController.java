package com.example.myhotel.controller;

import com.example.myhotel.model.Employee;
import com.example.myhotel.model.Hotel;
import com.example.myhotel.model.Rent;
import com.example.myhotel.service.implementation.EmployeeService;
import com.example.myhotel.service.implementation.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(addedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Employee employee) {
        employeeService.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the rent's start date, if it was provided in the request body
        String name = updatedEmployee.getName();
        if (name != null) {
            employee.setName(name);
        }

        // Update the rent's end date, if it was provided in the request body
        String address = updatedEmployee.getAddress();
        if (address != null) {
            employee.setAddress(address);
        }

        // Update the rent's room number, if it was provided in the request body
        String post = updatedEmployee.getPost();
        if (post != null) {
            employee.setPost(post);
        }

        // Update the rent's client ID, if it was provided in the request body
        Long hotelId = updatedEmployee.getHotel().getHotelID();
        if (hotelId != null) {
            employee.setHotel(hotelService.findById(hotelId));
        }

        Employee updatedRentObj = employeeService.save(employee);
        return ResponseEntity.ok(updatedRentObj);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findByName(name);
        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/ssn/{ssn}")
    public ResponseEntity<Employee> getEmployeeBySsn(@PathVariable int ssn) {
        Employee employee = employeeService.findBySSN(ssn);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }



    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByHotelId(@PathVariable Long id) {
        List<Employee> employees = employeeService.findByHotelID(id);
        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

}
