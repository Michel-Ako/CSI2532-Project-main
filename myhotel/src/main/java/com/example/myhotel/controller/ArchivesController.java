package com.example.myhotel.controller;


import com.example.myhotel.model.Archives;
import com.example.myhotel.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/archives")
public class ArchivesController {

    @Autowired
    private IArchivesService archiveService;

    @PostMapping
    public ResponseEntity<?> addArchive(@RequestBody Archives archive) {
        archiveService.save(archive);
        return ResponseEntity.ok().body("Archive added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArchive(@PathVariable int noArchives, @RequestBody Archives updatedArchive) {
        Archives archive = archiveService.findByNumber(noArchives);
        if (archive == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the archive's type, if it was provided in the request body
        String type = updatedArchive.getType();
        if (type != null) {
            archive.setType(type);
        }

        // Update the archive's number of files, if it was provided in the request body
        Integer numberOfFiles = updatedArchive.getNoArchive();
        if (numberOfFiles != null) {
            archive.setNoArchive(numberOfFiles);
        }

        // Save the updated archive to the repository
        archiveService.save(archive);

        return ResponseEntity.ok().body(archive);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArchive(@PathVariable int id) {
        Archives archive = archiveService.findByNumber(id);
        if (archive == null) {
            return ResponseEntity.notFound().build();
        }

        archiveService.delete(archive);

        return ResponseEntity.ok().body("Archive deleted successfully");
    }

    @GetMapping("/{idOrNumber}")
    public ResponseEntity<?> findArchiveByIdOrNumber(@PathVariable String idOrNumber) {
        Archives archive = null;
        if (idOrNumber.matches("\\d+")) {
            archive = archiveService.findByNumber(Integer.parseInt(idOrNumber));
        } else if (idOrNumber.matches("\\d+")) {
            archive = archiveService.findByNumber(int.parseint(idOrNumber));
        }
        if (archive == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(archive);
    }

}

