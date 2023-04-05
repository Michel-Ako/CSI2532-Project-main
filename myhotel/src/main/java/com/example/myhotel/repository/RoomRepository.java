package com.example.myhotel.repository;
import com.example.myhotel.utils.Queries;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.myhotel.model.Room;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query(value = "SELECT r FROM Room r WHERE r.capacity >= :minCapacity AND r.capacity <= :maxCapacity " +
            "AND r.RoomType = :roomType " +
            "AND r.extent = :extent " + "AND r.view = :view "+
            "AND r.hotel.chain = :hotelChain "+
            "AND r.price >= :minPrice AND r.price <= :maxPrice " +
            "AND NOT EXISTS (SELECT 1 FROM Reservation res WHERE res.room = r AND " +
            "((res.startDate BETWEEN :startDate AND :endDate) OR (res.endDate BETWEEN :startDate AND :endDate)))", nativeQuery = true)
    List<Room> findAvailableRooms(@Param("minCapacity") int minCapacity, @Param("maxCapacity") int maxCapacity,
                                  @Param("roomType") String roomType, @Param("extent") boolean extent, @Param("view") String view,
                                  @Param("hotelChain") String hotelChain,
                                  @Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice,
                                  @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);



    @Query(value = Queries.findAllRoomsByRoomNumber, nativeQuery = true)
    Room findByRoomNumber(@Param("roomNumber") int roomNumber);


    @Query(value = Queries.findAllRoomsByRoomType, nativeQuery = true)
    List<Room> findByRoomType(@Param("roomType") String roomType);


    @Query(value = Queries.findAllRoomsByView, nativeQuery = true)
    List<Room> findByView(@Param("view") String view);


    @Query(value = Queries.findAllRoomsByExtent, nativeQuery = true)
    List<Room> findByExtent(@Param("extent") boolean extent);






    List<Room> findByPriceBetween(@Param("minPrice") BigDecimal minPrice,@Param("maxPrice")  BigDecimal maxPrice);


    List<Room> findByCapacityBetween(@Param("minCapacity") int minCapacity,@Param("maxCapacity")  int maxCapacity);

    @Query(value = Queries.findAllRoomsByAvailability , nativeQuery = true)
    List<Room> findByAvailability(@Param("availability") boolean available);


   /* @Modifying
    @Transactional
    @Query(value = "DELETE FROM Room WHERE room_number = :roomNumber", nativeQuery = true)
    void deleteByRoomNumber(@Param("roomNumber") int roomNumber);*/

}


