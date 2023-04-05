package com.example.myhotel.service;
import com.example.myhotel.model.Hotel;
import com.example.myhotel.repository.HotelRepository;
import com.example.myhotel.model.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeService {

    Employee findById(Long ID);

    List<Employee> findByName(String name);

    Employee findBySSN(int SSN);
    List<Employee> findByHotelID(long hotelID);

    void changePost(Long ID, String post);

    Employee save(Employee employee);

    void delete(Employee employee);

    List<Employee> findAll();

}