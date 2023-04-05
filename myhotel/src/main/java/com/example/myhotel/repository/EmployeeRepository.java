package com.example.myhotel.repository;
import com.example.myhotel.model.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.myhotel.utils.Queries;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    @Query(value = Queries.findAllEmployeesByID, nativeQuery = true)
    Optional<Employee> findById(@Param("employee_ID") Long ID);


    @Query(value = Queries.findAllEmployeesByName, nativeQuery = true)
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM employee WHERE id_hotel = :id_hotel;", nativeQuery = true)
    List<Employee> findByHotelID(@Param("id_hotel") long hotelID);

    @Query(value = Queries.findAllEmployeesBySSN, nativeQuery = true)
    Employee findBySSN(@Param("ssn") int SSN);

    @Modifying
    @Query(value = Queries.changePost, nativeQuery = true)
    void changePost(@Param("employee_ID") Long ID, @Param("post") String post);

    @Override
    Employee save(Employee employee);

}
