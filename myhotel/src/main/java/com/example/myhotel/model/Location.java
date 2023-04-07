package com.example.myhotel.model;

import javax.persistence.*;
import javax.persistence.FetchType;
import java.time.LocalDateTime;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private int id;

    @Column(name = "date_reservation")
    private LocalDateTime dateReservation;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    @Column(name = "numero_chambre")
    private int numeroChambre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_archive", referencedColumnName = "numero_archive")
    private Archives archive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public Archives getArchive() {
        return archive;
    }

    public void setArchive(Archives archive) {
        this.archive = archive;
    }
}
