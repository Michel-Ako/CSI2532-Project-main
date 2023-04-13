package com.example.myhotel.repository;
import com.example.myhotel.model.Archives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArchivesRepository extends JpaRepository<Archives, Integer> {
}