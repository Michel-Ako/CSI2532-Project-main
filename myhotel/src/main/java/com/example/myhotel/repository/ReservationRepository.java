package com.example.myhotel.repository;
import com.example.myhotel.model.Reservation;
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
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = Queries.findAllReservationsByID, nativeQuery = true)
    Optional<Reservation> findByID(@Param("reservation_ID") Long reservation_ID);


    @Query(value = Queries.findAllReservationsByDate, nativeQuery = true)
    List<Reservation> findByDate(@Param("reservationdate") LocalDate reservationdate);


    @Query(value = Queries.findAllReservationsByStartDate, nativeQuery = true)
    List<Reservation> findByStartDate(@Param("startdate") LocalDate startdate);


    @Query(value = Queries.findAllReservationsByEndDate, nativeQuery = true)
    List<Reservation> findByEndDate(@Param("enddate") LocalDate enddate);


    @Query(value = Queries.findAllReservationsByCustomerID, nativeQuery = true)
    List<Reservation> findByCustomerID(@Param("client_ID") Long client_ID);


    @Query(value = Queries.findAllReservationsByArchiveNumber, nativeQuery = true)
    List<Reservation> findByArchiveNumber(@Param("noArchive") int noArchive);

    @Query(value = "SELECT *\n" +
            "FROM Reservation r1, Reservation r2\n" +
            "WHERE r1.roomNumber = r2.roomNumber\n" +
            "  AND r1.id <> r2.id\n" +
            "  AND ((r1.startdate <= r2.endDate AND r1.enddate >= r2.enddate)\n" +
            "       OR (r1.startdate >= r2.startDate AND r1.startDate <= r2.endDate))\n", nativeQuery = true)
    List<Reservation> findConflictingReservations(@Param("roomNumber") int roomNumber, @Param("startdate") LocalDate startDate, @Param("enddate")  LocalDate endDate, @Param("reservation_ID") int reservation_ID);

    @Modifying
    @Query(value = Queries.changeReservationDate, nativeQuery = true)
    void changeDate(@Param("reservation_ID") Long reservation_ID, @Param("reservationdate") LocalDate reservationdate);

    @Modifying
    @Query(value = Queries.changeReservationStartDate, nativeQuery = true)
    void changeStartDate(@Param("reservation_ID") Long reservation_ID, @Param("startdate") LocalDate startdate);

    @Modifying
    @Query(value = Queries.changeReservationEndDate, nativeQuery = true)
    void changeEndDate(@Param("reservation_ID") Long reservation_ID, @Param("enddate") LocalDate enddate);

    @Modifying
    @Query(value = Queries.changePost, nativeQuery = true)
    void changePost(@Param("post") String post);

    @Override
    Reservation save(Reservation reservation);
}
