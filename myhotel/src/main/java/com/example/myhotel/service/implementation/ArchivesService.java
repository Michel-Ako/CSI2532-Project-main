package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Archives;
import com.example.myhotel.repository.ArchivesRepository;
import com.example.myhotel.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivesService implements IArchivesService {

    private final ArchivesRepository archivesRepository;

    @Autowired
    public ArchivesService(ArchivesRepository archivesRepository) {
        this.archivesRepository = archivesRepository;
    }

    public Archives findByNumber(int numberOfArchives) {
        return archivesRepository.findByNumber(numberOfArchives);
    }

    @Override
    public List<Archives> findByID(int ID) {
        return archivesRepository.findByID(ID);
    }

    @Override
    public void changeArchivesType(int numberOfArchives, String type) {
        Archives archives = archivesRepository.findByNumber(numberOfArchives);
        archives.setType(type);
        archivesRepository.save(archives);
    }

    @Override
    public void changeArchivesID(int numberOfArchives, int archiveID) {
        Archives archives = archivesRepository.findByNumber(numberOfArchives);
        archives.setID(archiveID);
        archivesRepository.save(archives);
    }

    @Override
    public void save(Archives archive) {
        archivesRepository.save(archive);
    }

    public List<Archives> findAll() {
        Iterable<Archives> archivesIterable = archivesRepository.findAll();
        return archivesIterable != null ? (List<Archives>) archivesIterable : new ArrayList<>();
    }

    @Override
    public void delete(Archives archive) {
        archivesRepository.delete(archive);
    }
}
