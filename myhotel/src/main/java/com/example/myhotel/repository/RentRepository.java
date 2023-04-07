package com.example.myhotel.repository;

import com.example.myhotel.model.Rent;
import com.example.myhotel.utils.Queries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    Optional<Rent> findByRentId(int rentId);

    List<Rent> findByRentDate(LocalDate rentDate);

    Rent findByRoomNumber(int roomNumber);

    List<Rent> findByClientId(int clientId);

    List<Rent> findByStartDate(LocalDate startDate);

    List<Rent> findByEndDate(LocalDate endDate);

    @Modifying
    @Query(value = Queries.changeDate, nativeQuery = true)
    void changeDate(@Param("rentId") int rentId, @Param("rentDate") LocalDate rentDate);

    @Modifying
    @Query(value = Queries.changeStartDate, nativeQuery = true)
    void changeStartDate(@Param("rentId") int rentId, @Param("startDate") LocalDate startDate);

    @Modifying
    @Query(value = Queries.changeEndDate, nativeQuery = true)
    void changeEndDate(@Param("rentId") int rentId, @Param("endDate") LocalDate endDate);

    @Override
    Rent save(Rent rent);
}
