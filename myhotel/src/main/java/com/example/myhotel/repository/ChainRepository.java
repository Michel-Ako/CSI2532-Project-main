package com.example.myhotel.repository;
import com.example.myhotel.model.Chain;
import com.example.myhotel.utils.Queries;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends CrudRepository< Chain, String> {
    @Override
    @Query(value = Queries.findAllChainsByName, nativeQuery = true)
    Optional<Chain> findById(@Param("chain_name") String name);

    @Query(value = Queries.findAllChains, nativeQuery = true)
    Collection<String[]> findAllChains();

    @Override
    Chain save(Chain chain);

    @Override
    void delete(Chain chain);

//    @Modifying
//    @Query("UPDATE Hotel h SET h.noHotels = :noHotels WHERE h.chain_name = :chain_name")
//    void changeNumberOfHotels(@Param("chain_name") String chain_name, @Param("noHotels") int noHotels);


}

