package com.example.myhotel.repository;
import com.example.myhotel.model.Archives;
import com.example.myhotel.utils.Queries;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ArchivesRepository extends CrudRepository<Archives, Integer> {


    @Query(value = Queries.findAllArchivesByNumber, nativeQuery = true)
    Archives findByNumber(@Param("noArchive") long numberOfArchives);


    @Query(value = Queries.findAllArchivesByID, nativeQuery = true)
    List<Archives> findByID(@Param("archives_ID") int ID);

    @Modifying
    @Query(value = Queries.changeArchivesType, nativeQuery = true)
    void changeArchivesType(@Param("noArchive") int numberOfArchives, @Param("type") String type);

    @Modifying
    @Transactional
    @Query("UPDATE Archives SET archives_ID = :ID WHERE noArchive = :noArchive")
    void changeArchivesID(@Param("ID") int newArchivesID, @Param("noArchive") int archiveNo);



    Archives save(Archives archive);
}