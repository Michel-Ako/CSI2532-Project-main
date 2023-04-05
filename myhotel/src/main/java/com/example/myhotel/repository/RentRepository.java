package com.example.myhotel.repository;
import com.example.myhotel.model.Rent;
import com.example.myhotel.utils.Queries;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {


    @Query(value = Queries.findAllRentByID, nativeQuery = true)
    Optional<Rent> findByNumber(@Param("rent_ID") Long rent_ID);


    @Query(value = Queries.findAllRentByDate, nativeQuery = true)
    List<Rent> findByDate(@Param("rentdate") LocalDate rentdate);

    @Query(value = "SELECT * FROM reservations WHERE room_number = :roomNumber;", nativeQuery = true)
    Rent findByRoomNumber(@Param("roomNumber") int roomNumber);

    @Query(value = "SELECT * FROM reservations WHERE client_ID = :client_ID;", nativeQuery = true)
    List<Rent> findByClientID(@Param("client_ID") long client_ID);

    @Query(value = Queries.findAllRentByStartDate, nativeQuery = true)
    List<Rent> findByStartDate(@Param("startdate") LocalDate startdate);


    @Query(value = Queries.findAllRentByEndDate, nativeQuery = true)
    List<Rent> findByEndDate(@Param("enddate") LocalDate enddate);

    @Modifying
    @Query(value = Queries.changeDate, nativeQuery = true)
    void changeDate(@Param("rent_ID") Long rent_ID, @Param("rentdate") LocalDate rentdate);

    @Modifying
    @Query(value = Queries.changeStartDate, nativeQuery = true)
    void changeStartDate(@Param("rent_ID") Long rent_ID, @Param("startdate") LocalDate startdate);

    @Modifying
    @Query(value = Queries.changeEndDate, nativeQuery = true)
    void changeEndDate(@Param("rent_ID") Long rent_ID, @Param("enddate") LocalDate enddate);


    @Override
    Rent save(Rent rent);
}
