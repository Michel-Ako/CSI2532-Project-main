package com.example.myhotel.service;
import com.example.myhotel.model.Archives;

import java.util.List;

public interface IArchivesService {

    Archives findByNumber(int numberOfArchives);

    List<Archives> findByID(int ID);

    void changeArchivesType(int numberOfArchives, String type);

    void changeArchivesID(int numberOfArchives, int archiveID);

    void save(Archives archive);

    List<Archives> findAll();

    void delete(Archives archive);

}
