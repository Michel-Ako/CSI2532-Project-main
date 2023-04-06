package com.example.myhotel.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @ManyToOne
    @JoinColumn(name = "numero_archive")
    private Archives archive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_ID", nullable = false)
    private int reservationID;

    @Column(name = "reservationdate")
    private LocalDate reservationDate;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @Column(name = "roomNumber")
    private int roomNumber;

    @ManyToOne(targetEntity = Clients.class)
    @JoinColumn(name = "client_ID", referencedColumnName = "client_ID")
    private Clients client_ID;

    public Reservation() {}

    public Reservation(LocalDate startDate, LocalDate endDate, int roomNumber, Archives archive, Clients client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.archive = archive;
        this.client_ID = client;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Archives getArchive() {
        return archive;
    }

    public void setArchive(Archives archive) {
        this.archive = archive;
    }

    public Clients getClient() {
        return client_ID;
    }

    public void setClient(Clients client) {
        this.client_ID = client;
    }

    @PrePersist
    public void prePersist(){
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationID=" + reservationID + ", reservationDate=" + reservationDate
                + ", startDate=" + startDate + ", endDate=" + endDate + ", roomNumber=" + roomNumber
                + ", archive=" + archive + ", client=" + client_ID + '}';
    }
}
