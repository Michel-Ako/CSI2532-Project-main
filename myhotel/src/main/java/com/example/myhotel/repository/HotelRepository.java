package com.example.myhotel.repository;
import com.example.myhotel.model.Hotel;
import com.example.myhotel.utils.Queries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    @Override
    @Query(value = Queries.findAllHotelsByID, nativeQuery = true)
    Optional<Hotel> findById(@Param("id_hotel") Long ID);


    @Query(value = Queries.findAllHotelsByName, nativeQuery = true)
    List<Hotel> findByName(@Param("name") String name);


    @Query(value = Queries.findAllHotelsByRatings, nativeQuery = true)
    List<Hotel> findByRatings(@Param("rating") int rating);

    @Override
    Hotel save(Hotel hotel);

    @Modifying
    @Query(value = Queries.changeManager, nativeQuery = true)
    void changeManager(@Param("id_hotel") Long ID, @Param("gestionnaire_id") String gestionnaire_id);

    @Query("SELECT h FROM Hotel h WHERE h.name = :name OR h.chain = :chain_name OR h.rating = :rating")
    List<Hotel> findByNameOrChainOrRating(@Param("name") String name, @Param("chain_name") String chain, @Param("rating") Integer rating);
}
