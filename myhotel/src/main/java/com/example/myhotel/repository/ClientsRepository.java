package com.example.myhotel.repository;
import com.example.myhotel.model.Clients;
import com.example.myhotel.utils.Queries;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ClientsRepository extends CrudRepository<Clients, Long> {

    @Override
    @Query(value = Queries.findAllClientsByID, nativeQuery = true)
    Optional<Clients> findById(@Param("client_ID") Long ID);


    @Query(value = Queries.findAllClientsByName, nativeQuery = true)
    List<Clients> findByName(@Param("name") String name);


    @Query(value = Queries.findAllClientsBySSN, nativeQuery = true)
    List<Clients> findBySSN(@Param("SSN") int SSN);
    @Query(value =" SELECT * FROM clients WHERE id_hotel = :id_hotel;", nativeQuery = true)
    List<Clients> findByHotelID(@Param("id_hotel") long ID);

    @Query(value =" SELECT * FROM clients WHERE payment = :payment;", nativeQuery = true)
    List<Clients> findByPaymentStatus(@Param("payment") String payment);

    @Modifying
    @Query(value = Queries.changeCheckInDate, nativeQuery = true)
    void changeCheckInDate(@Param("client_ID") Long ID, @Param("checkin") LocalDate checkin);

    @Modifying
    @Transactional
    @Query(value = Queries.changePaymentStatus, nativeQuery = true)
    void changePaymentStatus(@Param("client_ID") Long ID, @Param("payment") String paymentStatus);

    @Override
    Clients save(Clients client);
}
