package com.example.myhotel.service;

import com.example.myhotel.model.Archives;

import java.util.List;

public interface IArchivesService {
    List<Archives> getAllArchives();
    Archives getArchiveById(int id);
    Archives createArchive(Archives archive);
    Archives updateArchive(int id, Archives archive);
    void deleteArchive(int id);
}
