package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Archives;
import com.example.myhotel.repository.ArchivesRepository;
import com.example.myhotel.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchivesService implements IArchivesService {

    @Autowired
    private ArchivesRepository archiveRepository;

    @Override
    public List<Archives> getAllArchives() {
        return (List<Archives>) archiveRepository.findAll();
    }

    @Override
    public Archives getArchiveById(int id) {
        Optional<Archives> optionalArchive = archiveRepository.findById(id);
        return optionalArchive.orElse(null);
    }

    @Override
    public Archives createArchive(Archives archive) {
        return archiveRepository.save(archive);
    }

    @Override
    public Archives updateArchive(int id, Archives archive) {
        Optional<Archives> optionalArchive = archiveRepository.findById(id);
        if (optionalArchive.isPresent()) {
            Archives existingArchive = optionalArchive.get();
            existingArchive.setTypeArchive(archive.getTypeArchive());
            existingArchive.setIdArchive(archive.getIdArchive());
            return archiveRepository.save(existingArchive);
        } else {
            return null;
        }
    }

    @Override
    public void deleteArchive(int id) {
        archiveRepository.deleteById(id);
    }
}
