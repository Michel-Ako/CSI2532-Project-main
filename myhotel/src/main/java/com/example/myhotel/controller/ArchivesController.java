package com.example.myhotel.controller;

import com.example.myhotel.model.Archives;
import com.example.myhotel.model.Archives;
import com.example.myhotel.service.implementation.ArchivesService;
import com.example.myhotel.service.implementation.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archive")
public class ArchivesController {
    @Autowired
    private ArchivesService archiveService;

    @GetMapping
    public ResponseEntity<List<Archives>> getAllArchives() {
        return ResponseEntity.ok(archiveService.getAllArchives());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Archives> getArchiveById(@PathVariable int id) {
        Archives archive = archiveService.getArchiveById(id);
        return archive != null ? ResponseEntity.ok(archive) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Archives> createArchive(@RequestBody Archives archive) {
        return ResponseEntity.ok(archiveService.createArchive(archive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Archives> updateArchive(@PathVariable int id, @RequestBody Archives archive) {
        Archives updatedArchive = archiveService.updateArchive(id, archive);
        return updatedArchive != null ? ResponseEntity.ok(updatedArchive) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArchive(@PathVariable int id) {
        Archives archive = archiveService.getArchiveById(id);
        if (archive != null) {
            archiveService.deleteArchive(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
