package com.example.myhotel.model;

import java.util.Date;

public class Reservation {
    private int numeroReservation;
    private Date dateDebut;
    private Date dateFin;
    private Clients client;
    private Room chambre;

    public Reservation(int numeroReservation, Date dateDebut, Date dateFin, Clients client, Room chambre) {
        this.numeroReservation = numeroReservation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.chambre = chambre;
    }

    public int getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Room getChambre() {
        return chambre;
    }

    public void setChambre(Room chambre) {
        this.chambre = chambre;
    }
}
