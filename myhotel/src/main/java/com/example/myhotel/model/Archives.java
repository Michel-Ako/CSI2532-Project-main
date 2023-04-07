package com.example.myhotel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "archive")
public class Archives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_archive")
    private int numeroArchive;

    @Column(name = "type_archive")
    private String typeArchive;

    @Column(name = "id_archive", unique = true)
    private int idArchive;

    @OneToMany(mappedBy = "archive", cascade = CascadeType.ALL)
    private List<Location> locations;

    public int getNumeroArchive() {
        return numeroArchive;
    }

    public void setNumeroArchive(int numeroArchive) {
        this.numeroArchive = numeroArchive;
    }

    public String getTypeArchive() {
        return typeArchive;
    }

    public void setTypeArchive(String typeArchive) {
        this.typeArchive = typeArchive;
    }

    public int getIdArchive() {
        return idArchive;
    }

    public void setIdArchive(int idArchive) {
        this.idArchive = idArchive;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
